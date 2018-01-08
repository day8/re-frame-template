# re-frame-template

Leiningen template for [reagent](https://github.com/reagent-project/reagent) web apps that implements the [re-frame](https://github.com/Day8/re-frame) pattern.

Through the use of profiles, this template lets the developer pick and choose what is included in their application.

## Usage

The base template includes:

* [re-frame](https://github.com/Day8/re-frame)
* [figwheel](https://github.com/bhauman/lein-figwheel)
* [cljs-devtools](https://github.com/binaryage/cljs-devtools)

To create an application with the base template:

```
lein new re-frame <project-name>
```

The optional profiles include:

* [cider](https://github.com/clojure-emacs/cider) (`+cider`)
* [cljs.test](https://github.com/clojure/clojurescript/blob/master/src/main/cljs/cljs/test.cljs) and [doo](https://github.com/bensu/doo) (`+test`)
* [compojure](https://github.com/weavejester/compojure) (`+handler`)
* [garden](https://github.com/noprompt/garden) (`+garden`)
* [less](https://github.com/montoux/lein-less) (`+less`)
* [re-com](https://github.com/Day8/re-com) (`+re-com`)
* [re-frame-trace](https://github.com/Day8/re-frame-trace) (`+trace`)
* [re-frisk](https://github.com/flexsurfer/re-frisk) (`+re-frisk`)
* [secretary](https://github.com/gf3/secretary) (`+routes`)
* Helper aliases `lein build` and `lein dev` (`+aliases`)

To add a profile to the base template, just append the profile name (let's use `+re-com` as an example):

```
lein new re-frame <project-name> +re-com
```

Any combination of profiles can be added at once:

```
lein new re-frame <project-name> +garden +re-com +routes +test +less +re-frisk
```

>  Note: to assist debugging, you'll probably want to include either `+re-frisk` or `+trace`. 


### Start Cider from Emacs (if using +cider):

Put this in your Emacs config file:

```
(setq cider-cljs-lein-repl
	"(do (require 'figwheel-sidecar.repl-api)
         (figwheel-sidecar.repl-api/start-figwheel!)
         (figwheel-sidecar.repl-api/cljs-repl))")
```

Navigate to a clojurescript file and start a figwheel REPL with `cider-jack-in-clojurescript` or (`C-c M-J`)


### Compile css (if using +garden or +less):

Compile css file once.

```
lein garden once

lein less once
```


Automatically recompile css file on change.

```
lein garden auto

lein less auto
```

When using +aliases css also gets automatically built when running `lein build` and recompiled on change with `lein dev`.

### Run application:

```
lein clean
lein figwheel dev
```

When using +aliases you can just run:
```
lein dev
```

Figwheel will automatically push cljs changes to the browser.

Wait a bit, then browse to [http://localhost:3449](http://localhost:3449).

## Setting Up Your Browser

So, you now have the application running.  
Before you start developing, you should tweak two settings within your 
browser's `devtools`. These are one-time actions (for each browser and laptop you use). 
I'll assume Chrome for the purposes of further explanation: 

1. Open devtools - press `F12` or `Ctrl-Shift-i` ([actually there's a variety of ways](https://developer.chrome.com/devtools))
1. Now press F1 to open up the devtools "Settings" panel. (Not the Setting panel for Chrome itself! The Settings panel for devtools)
1. Under the "Network" heading, tick the option "Disable cache (while DevTools is open)". You don't want figwheel's attempts at reloading to be defeated by caching. 
1. Under the "Console" heading, tick the option "Enable custom formatters". This allows [cljs-devtools](https://github.com/binaryage/cljs-devtools) to perform its magic.
1. Close Settings. Close Devtools. 
1. Reopen Devtools 

![settings](docs/images/devtools-settings.png)

### Open Debug Window (if using +trace):

To use `re-frame-trace` for debugging: 
  1. click on the application, minimal through it is, to give it "focus" (you want to be sure that any key presses are going to your new app)
  2. press `Ctrl-H` and you should see `re-frame-trace` appear on the right side of the window

Sometimes achieving Step 1 on a really simple app - one without widgets - can be a bit fiddly, 
because the browser itself hogs "focus" and grabs all the keystrokes (like `Ctrl-H`) which don't
then make it through to the app. You might need to be determined and creative with Step 1.

### debug?:

In _project-name.config_, there is a variable called `debug?`, which
defaults to _true_. However, for the `min` build, this variable is
re-defined to _false_.

When `debug?` is true, we include `(enable-console-print!)`. If you, for example, you wrap your `println`s with a `when` block as show below, then you will get logs printed to the browser's console for the `dev` build and not the `min` build.

```clojure
(when config/debug?
  (println "dev mode"))
```

### Run tests (if using +test):

```
lein clean
lein doo phantom test once
```

The above command assumes that you have [phantomjs](https://www.npmjs.com/package/phantomjs) installed. However, please note that [doo](https://github.com/bensu/doo) can be configured to run cljs.test in many other JS environments (chrome, ie, safari, opera, slimer, node, rhino, or nashorn).

## Production Build

To compile clojurescript to javascript:

```
lein clean
lein cljsbuild once min
```
When using +aliases you can just run:
```
lein build
```

If you're using +handler

```
lein clean
lein uberjar
```

To deploy to heroku, first create your app:

```
heroku create
```

Then deploy the application:

```
git push heroku master
```

## Other Templates

* [chestnut](https://github.com/plexus/chestnut)
* [luminus](https://github.com/luminus-framework/luminus-template)  (full stack)
* [reagent-figwheel](https://github.com/gadfly361/reagent-figwheel)
* [reagent-seed](https://github.com/gadfly361/reagent-seed)

## Backend Options

* [ring](https://github.com/ring-clojure/ring) and [liberator](http://clojure-liberator.github.io/liberator/)
* [duct]()https://github.com/duct-framework/duct)
* [yada](https://github.com/juxt/yada)
* [pedestal](https://github.com/pedestal/pedestal) and [vase](https://github.com/cognitect-labs/vase)

## More re-frame

Looking for more re-frame inspiration, templates or example applications?
See the [external resources](https://github.com/Day8/re-frame/blob/master/docs/External-Resources.md) docs page.

## Contributing

Contributions are welcomed!  To add a new profile, this is what I'd recommend:

1. Add a file with the name of the profile [here](https://github.com/Day8/re-frame-template/tree/master/src/leiningen/new/options)
2. Look at the existing options in that folder for inspiration for what to include in that file
3. Update [project.clj](https://github.com/Day8/re-frame-template/blob/master/src/leiningen/new/re_frame.clj) with the profile
4. Add any new files [here](https://github.com/Day8/re-frame-template/tree/master/src/leiningen/new/re_frame) and use the {{ var-name }} syntax as needed
5. Update the [README](https://github.com/Day8/re-frame-template/tree/master/src/leiningen/new/re_frame) that will result when the template is used, as well as the top-level [README](https://github.com/Day8/re-frame-template/blob/master/README.md) for re-frame-template itself
6. In a terminal, at the root of re-frame-template, run `lein install`
7. Locally test that your profile works, `lein new re-frame <app-name> +<profile-name>`
8. Add your profile to [create-templates](https://github.com/Day8/re-frame-template/blob/master/create-templates.sh) and run the script to make sure the other profiles didn't break.

## License

```
The MIT License (MIT)

Copyright © 2015 Matthew Jaoudi
Copyright © 2015 Dylan Paris
Copyright © 2015 Michael Thompson
Copyright © 2015 Markku Rontu

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
