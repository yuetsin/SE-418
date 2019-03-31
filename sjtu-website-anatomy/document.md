# SJTU Website Load Process
## Summary
* 106 Requests
* 35.8 KB transferred
* 9.5 MB resources
* in 5.09 seconds
* 977 ms for DOM Loading
* 1.59s for other resources
  
## Environment
* OS:       Mac OS X Version 10.14.4 (18E226)
* Browser:  Google Chrome Version 73.0.3683.86 (Stable) (64 bits)
* Kernel:   WebKit 537.36
* UA:       Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36

## Loading Stuff
* `www.sjtu.edu.cn`
  * This HTML contains all news information and its layout information as a HTML document.
  * Some JavaScript function is also embedded in this document, such as getTimeArr (parsing the time and date area in the website), getMessage (getting latest news information).
* `ETUI.min.css` & `ETUI.Utility.css` & `ETUI3.min.js`
  * There's little information about this "ETUI" library, but we can find out that some other websites also used this library, but it's not open source, nor its product page can be found.
  * So we may take that as a internal professional library, mainly used in official websites.
* Owl Carousel Library
  * It's a library to create "touch enabled jQuery plugin that lets you create a beautiful responsive carousel slider" (quoted [here](https://owlcarousel2.github.io/OwlCarousel2/))
  * It'a open source project under MIT license.
* `keyframes.css`
  * This css file intends to create motion effects in the website. Animations would be automatically fitted among the key frames, which resembles the animation in the website, mainly the mouse hover effect.
* `datetimepicker.css` & `jquery.ma.infinitypush.css` & `jquery.ma.infinitypush.js`
  * These are jQuery defined css files, included to create date picker, the latter one would create a "infinity push" effect.
* `style.css`
  * That's the css file controls how the elements combined altogether.
* `20xxxxxx_01xxxxx_xxx.jpg` (several images)
  * These images are mentioned in the HTML document, so now they're requested altogether.
* `jquery.min.1.12.4.js`
  * The famous jquery library script.
* Except these JavaScript, here's one interesting one:
  * the `zh-cn.js` is the dynamically loaded Chinese UI language pack, containing all localized strings in the website.
* SVGs
  * `footDoorBG.svg`
  * `footDoor.svg`
  * `footer-logo.svg`
  * These three svg are vector images in the website footer. Using svg files can reduce website size and provide sharper display effects.

## Optimization
There are several points that could optimize loading speed:
* Reduce unnecessary libraries
  There are so many libraries used in this simple website. They will not only slow down the loading speed but also lagging down the user experience.
* Make images preceedingly load
  It's not so necessary loads every image resource before loading JavaScript. That would make UI constructed before the JS loaded into the browser.
* There are too many segmented UI elements in the website.
  If we can combine them as one whole image, and trim them into pieces as use, we can reduce segmented files' loading time.