# re-frame-template

Leiningen template for [reagent](https://github.com/reagent-project/reagent) web apps that implements the [re-frame](https://github.com/Day8/re-frame) pattern.

Through the use of profiles, this template lets the developer pick and choose what is included in their application.

## Usage

The base template includes:

* [re-frame](https://github.com/Day8/re-frame)
* [figwheel](https://github.com/bhauman/lein-figwheel)
* [cljs-devtools](https://github.com/binaryage/cljs-devtools)
    * To enable: 1) Open Chrome's DevTools,`Ctrl-Shift-i`; 2) open "Settings", `F1`; 3) Check "Enable custom formatters" under the "Console" section; 4) close and re-open DevTools

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
* [secretary](https://github.com/gf3/secretary) (`+routes`)

To add a profile to the base template, just append the profile name (let's use `+re-com` as an example):

```
lein new re-frame <project-name> +re-com
```

Any combination of profiles can be added at once:

```
lein new re-frame <project-name> +garden +re-com +routes +test +less
```

## Development Mode

### Start Cider from Emacs (if using +cider):

Put this in your Emacs config file:

```
(setq cider-cljs-lein-repl "(do (use 'figwheel-sidecar.repl-api) (start-figwheel!) (cljs-repl))")
```

Navigate to a clojurescript file and start a figwheel REPL with `cider-jack-in-clojurescript` or (`C-c M-J`)


### Compile css (if using +garden or +less):

Compile css file once.

```
lein garden once
```

or

```
lein less once
```

Automatically recompile css file on change.

```
lein garden auto
```

or

```
lein less auto
```

### Run application:

```
lein clean
lein figwheel dev
```

Figwheel will automatically push cljs changes to the browser.

Wait a bit, then browse to [http://localhost:3449](http://localhost:3449).

### Logging:

In _project-name.config_, there is a variable called `debug?`, which
defaults to _true_. However, for the `min` build, this variable is
re-defined to _false_.

When `debug?` is true, we include `(enable-console-print!)`. If you wrap all of your `println`s with a `when` block as show below, then you will get logs printed to the browser's console for the `dev` build and not the `min` build.

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

```
lein clean
lein cljsbuild once min
```

If you're using +handler

```
lein clean
lein uberjar
```

## Other Templates

* [reagent-figwheel](https://github.com/gadfly361/reagent-figwheel)
* [reagent-seed](https://github.com/gadfly361/reagent-seed)

## Misc.

Looking for some re-frame scaffolding? Check out [slush-reframe](https://github.com/kristianmandrup/slush-reframe).

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

Desired profiles:

* `+heroku`

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
