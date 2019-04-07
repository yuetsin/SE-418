import { Component, Vue } from 'vue-property-decorator'
import bContainer from 'bootstrap-vue/es/components/layout/container'
import bCol from 'bootstrap-vue/es/components/layout/col'
import bRow from 'bootstrap-vue/es/components/layout/row'
import HttpRequest from '../../axios/api.request'
import './home.scss'

let VueMaterial = require('vue-material')
Vue.use(VueMaterial)

@Component({
  template: require('./home.html'),
  components: {
    'b-container': bContainer,
    'b-col': bCol,
    'b-row': bRow
  }
})
export class HomeComponent extends Vue {
  package: string = 'vue-webpack-typescript'
  repo: string = 'https://github.com/ducksoupdev/vue-webpack-typescript'
  mode: string = process.env.ENV
  ladder: string[] = []
  startWord: string = ''
  endWord: string = ''
  complete: boolean = false
  loading: boolean = false
  showInfo: boolean = false
  infoTitle: string = ''
  infoMsg: string = ''
  checkComplete () {
    if (this.startWord.length === 0 || this.endWord.length === 0) {
      this.complete = false
    } else {
      this.complete = true
    }
  }

  startClick () {
    this.loading = true
    HttpRequest.request({
      url: '/ladder?start=' + this.startWord + '&end=' + this.endWord,
      method: 'get'
    }).then(response => {
      if (response['data']['status'] === 'ok') {
        this.ladder = response['data']['ladders']
      } else {
        this.infoTitle = 'Error!'
        this.infoMsg = 'Error Message: ' + response['data']['status']
        this.showInfo = true
      }
      console.log(response)
      this.loading = false
    }).catch(error => {
      console.log('Error occured: ' + error)
      this.infoTitle = 'Error!'
      this.infoMsg = 'Error Message: ' + error.toString()
      this.showInfo = true
      this.loading = false
    })
  }
}
