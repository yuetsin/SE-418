import axios from 'axios'
import config from './index'
const baseUrl = process.env.NODE_ENV === 'development' ? config.baseUrl.dev : ''

const HttpRequest = axios.create({
  baseURL: baseUrl,
  timeout: 200000
})

export default HttpRequest
