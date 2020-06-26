# {{name}}

A [re-frame](https://github.com/day8/re-frame) application designed to ... well, that part is up to
you.

## Getting Started

### Project Overview

* Architecture:
[Single Page Application (SPA)](https://en.wikipedia.org/wiki/Single-page_application)
* Languages
  - Front end ([re-frame](https://github.com/day8/re-frame)): [ClojureScript](https://clojurescript.org/) (CLJS){{#handler?}}
  - Back end/middleware ([Compojure](https://github.com/weavejester/compojure)): [Clojure](https://clojure.org/){{/handler?}}{{#garden?}}
  - CSS compilation ([`lein-garden`](https://github.com/noprompt/lein-garden)): [Clojure](https://clojure.org/){{/garden?}}{{#less?}}
  - CSS compilation ([`lein-less`](https://github.com/montoux/lein-less)): [Less](http://lesscss.org/features/){{/less?}}{{#scss?}}
  - CSS compilation ([`lein-scss`](https://github.com/bluegray/lein-scss)): [Scss](https://sass-lang.com/){{/scss?}}
* Dependencies
  - UI framework: [re-frame](https://github.com/day8/re-frame)
  ([docs](https://github.com/day8/re-frame/blob/master/docs/README.md),
  [FAQs](https://github.com/day8/re-frame/blob/master/docs/FAQs/README.md)) ->
  [Reagent](https://github.com/reagent-project/reagent) ->
  [React](https://github.com/facebook/react){{#handler?}}
  - Full stack framework: [Compojure](https://github.com/weavejester/compojure)
  ([Wiki](https://github.com/weavejester/compojure/wiki), [API docs](http://weavejester.github.com/compojure)) ->
  [Ring](https://github.com/ring-clojure/ring)
  ([Wiki](https://github.com/ring-clojure/ring/wiki), [API docs](http://ring-clojure.github.com/ring)){{/handler?}}{{#routes?}}
  - Client-side routing: [Secretary](https://github.com/gf3/secretary){{/routes?}}{{#garden?}}
  - CSS rendering: [Garden](https://github.com/noprompt/garden){{/garden?}}{{#re-com?}}
  - UI components: [re-com](https://github.com/day8/re-com){{/re-com?}}{{#re-pressed?}}
  - Keyboard event handler: [re-pressed](https://github.com/gadfly361/re-pressed){{/re-pressed?}}{{#breaking-point?}}
  - Screen breakpoints tool: [BREAKING-POINT](https://github.com/gadfly361/breaking-point){{/breaking-point?}}
* Build tools
  - Project task & dependency management: [Leiningen](https://github.com/technomancy/leiningen)
  - CLJS compilation, REPL, & hot reload: [`shadow-cljs`](https://github.com/thheller/shadow-cljs){{#garden?}}
  - CSS compilation: [`lein-garden`](https://github.com/noprompt/lein-garden){{/garden?}}{{#less?}}
  - CSS compilation: [`lein-less`](https://github.com/montoux/lein-less){{/less?}}{{#scss?}}
  - CSS compilation: [`lein-scss`](https://github.com/bluegray/lein-scss){{/scss?}}{{#test?}}
  - Test framework: [cljs.test](https://clojurescript.org/tools/testing)
  - Test runner: [Karma](https://github.com/karma-runner/karma){{/test?}}
* Development tools
  - Debugging: [CLJS DevTools](https://github.com/binaryage/cljs-devtools){{#10x?}},
  [`re-frame-10x`](https://github.com/day8/re-frame-10x){{/10x?}}{{#re-frisk?}},
  [re-frisk](https://github.com/flexsurfer/re-frisk){{/re-frisk?}}{{#cider?}}
  - Emacs integration: [CIDER](https://github.com/clojure-emacs/cider){{/cider?}}{{#kondo?}}
  - Linter: [clj-kondo](https://github.com/borkdude/clj-kondo){{/kondo?}}

#### Directory structure

* [`/`](/../../): project config files{{#kondo?}}
* [`.clj-kondo/`](.clj-kondo/): lint config and cache files (cache files are not tracked; see
[`.gitignore`](.gitignore)){{/kondo?}}
* [`dev/`](dev/): source files compiled only with the [dev](#running-the-app) profile
  - [`cljs/user.cljs`](dev/cljs/user.cljs): symbols for use during development in the
[ClojureScript REPL](#connecting-to-the-browser-repl-from-a-terminal){{#less?}}
* [`less/`](less/): CSS compilation source files ([Less](http://lesscss.org/features/)){{/less?}}{{#scss?}}
* [`scss/`](scss/): CSS compilation source files ([Less](https://sass-lang.com/)){{/scss?}}
* [`resources/public/`](resources/public/): SPA root directory;
[dev](#running-the-app) / [prod](#production) profile depends on the most recent build{{#re-com?}}
  - [`vendor/`](resources/public/vendor/): UI component CSS, fonts, and images
  ([re-com](https://github.com/day8/re-com)){{/re-com?}}
  - [`index.html`](resources/public/index.html): SPA home page
    - Dynamic SPA content rendered in the following `div`:
        ```html
        <div id="app"></div>
        ```
    - Customizable; add headers, footers, links to other scripts and styles, etc.
  - Generated directories and files
    - Created on build with either the [dev](#running-the-app) or [prod](#production) profile
    - Deleted on `lein clean` (run by all `lein` aliases before building){{#garden?}}
    - `css/`: compiled CSS (`lein-garden`, can also be
[compiled manually](#compiling-css-with-lein-garden)){{/garden?}}{{#less?}}
    - `css/`: compiled CSS (`lein-less`, can also be
[compiled manually](#compiling-css-with-lein-less)){{/less?}}{{#scss?}}
    - `css/`: compiled CSS (`lein-scss`, can also be
[compiled manually](#compiling-css-with-lein-scss)){{/scss?}}
    - `js/compiled/`: compiled CLJS (`shadow-cljs`)
      - Not tracked in source control; see [`.gitignore`](.gitignore){{#handler?}}
* [`src/clj/{{sanitized}}/`](src/clj/{{sanitized}}/): Backend and middleware source files (Clojure,
[Compojure](https://github.com/weavejester/compojure)){{/handler?}}{{#garden?}}
* [`src/clj/{{sanitized}}/`](src/clj/{{sanitized}}/): CSS compilation source files (Clojure,
[Garden](https://github.com/noprompt/garden)){{/garden?}}
* [`src/cljs/{{sanitized}}/`](src/cljs/{{sanitized}}/): SPA source files (ClojureScript,
[re-frame](https://github.com/Day8/re-frame))
  - [`core.cljs`](src/cljs/{{sanitized}}/core.cljs): contains the SPA entry point, `init`{{#test?}}
* [`test/cljs/{{sanitized}}/`](test/cljs/{{sanitized}}/): test files (ClojureScript,
[cljs.test](https://clojurescript.org/tools/testing))
  - Only namespaces ending in `-test` (files `*_test.cljs`) are compiled and sent to the test runner{{/test?}}

### Editor/IDE

Use your preferred editor or IDE that supports Clojure/ClojureScript development. See
[Clojure tools](https://clojure.org/community/resources#_clojure_tools) for some popular options.

### Environment Setup

1. Install [JDK 8 or later](https://openjdk.java.net/install/) (Java Development Kit)
2. Install [Leiningen](https://leiningen.org/#install) (Clojure/ClojureScript project task &
dependency management)
3. Install [Node.js](https://nodejs.org/) (JavaScript runtime environment) which should include
   [NPM](https://docs.npmjs.com/cli/npm) or if your Node.js installation does not include NPM also install it.{{#test?}}
4. Install [karma-cli](https://www.npmjs.com/package/karma-cli) (test runner):
    ```sh
    npm install -g karma-cli
    ```
5. Install [Chrome](https://www.google.com/chrome/) or
[Chromium](https://www.chromium.org/getting-involved/download-chromium) version 59 or later
(headless test environment)
    * For Chromium, set the `CHROME_BIN` environment variable in your shell to the command that
    launches Chromium. For example, in Ubuntu, add the following line to your `.bashrc`:
        ```bash
        export CHROME_BIN=chromium-browser
       ```{{/test?}}{{#kondo?}}
6. Install [clj-kondo](https://github.com/borkdude/clj-kondo/blob/master/doc/install.md) (linter){{/kondo?}}
7. Clone this repo and open a terminal in the `{{name}}` project root directory
8. (Optional) Download project dependencies:
    ```sh
    lein deps
    ```{{#kondo?}}
9. (Optional) Setup [lint cache](https://github.com/borkdude/clj-kondo#project-setup):
    ```sh
    clj-kondo --lint "$(lein classpath)"
    ```
10. Setup
[linting in your editor](https://github.com/borkdude/clj-kondo/blob/master/doc/editor-integration.md){{/kondo?}}

### Browser Setup

Browser caching should be disabled when developer tools are open to prevent interference with
[`shadow-cljs`](https://github.com/thheller/shadow-cljs) hot reloading.

Custom formatters must be enabled in the browser before
[CLJS DevTools](https://github.com/binaryage/cljs-devtools) can display ClojureScript data in the
console in a more readable way.

#### Chrome/Chromium

1. Open [DevTools](https://developers.google.com/web/tools/chrome-devtools/) (Linux/Windows: `F12`
or `Ctrl-Shift-I`; macOS: `⌘-Option-I`)
2. Open DevTools Settings (Linux/Windows: `?` or `F1`; macOS: `?` or `Fn+F1`)
3. Select `Preferences` in the navigation menu on the left, if it is not already selected
4. Under the `Network` heading, enable the `Disable cache (while DevTools is open)` option
5. Under the `Console` heading, enable the `Enable custom formatters` option

#### Firefox

1. Open [Developer Tools](https://developer.mozilla.org/en-US/docs/Tools) (Linux/Windows: `F12` or
`Ctrl-Shift-I`; macOS: `⌘-Option-I`)
2. Open [Developer Tools Settings](https://developer.mozilla.org/en-US/docs/Tools/Settings)
(Linux/macOS/Windows: `F1`)
3. Under the `Advanced settings` heading, enable the `Disable HTTP Cache (when toolbox is open)`
option

Unfortunately, Firefox does not yet support custom formatters in their devtools. For updates, follow
the enhancement request in their bug tracker:
[1262914 - Add support for Custom Formatters in devtools](https://bugzilla.mozilla.org/show_bug.cgi?id=1262914).

## Development

### Running the App

Start a temporary local web server, build the app with the `dev` profile, and serve the app with
hot reload:

```sh
lein dev
```

Please be patient; it may take over 20 seconds to see any output, and over 40 seconds to complete.

When `[:app] Build completed` appears in the output, browse to
[http://localhost:8280/](http://localhost:8280/).

[`shadow-cljs`](https://github.com/thheller/shadow-cljs) will automatically push ClojureScript code
changes to your browser on save. To prevent a few common issues, see
[Hot Reload in ClojureScript: Things to avoid](https://code.thheller.com/blog/shadow-cljs/2019/08/25/hot-reload-in-clojurescript.html#things-to-avoid).

Opening the app in your browser starts a
[ClojureScript browser REPL](https://clojurescript.org/reference/repl#using-the-browser-as-an-evaluation-environment),
to which you may now connect.{{#cider?}}

#### Connecting to the browser REPL from Emacs with CIDER

Connect to the browser REPL:
```
M-x cider-jack-in-cljs
```

See
[Shadow CLJS User's Guide: Emacs/CIDER](https://shadow-cljs.github.io/docs/UsersGuide.html#cider)
for more information. Note that the mentioned [`.dir-locals.el`](.dir-locals.el) file has already
been created for you.

#### Connecting to the browser REPL from other editors{{/cider?}}{{^cider?}}

#### Connecting to the browser REPL from your editor{{/cider?}}

See
[Shadow CLJS User's Guide: Editor Integration](https://shadow-cljs.github.io/docs/UsersGuide.html#_editor_integration).
Note that `lein dev` runs `shadow-cljs watch` for you, and that this project's running build id is
`app`, or the keyword `:app` in a Clojure context.

Alternatively, search the web for info on connecting to a `shadow-cljs` ClojureScript browser REPL
from your editor and configuration.

For example, in Vim / Neovim with `fireplace.vim`
1. Open a `.cljs` file in the project to activate `fireplace.vim`
2. In normal mode, execute the `Piggieback` command with this project's running build id, `:app`:
    ```vim
    :Piggieback :app
    ```

#### Connecting to the browser REPL from a terminal

1. Connect to the `shadow-cljs` nREPL:
    ```sh
    lein repl :connect localhost:8777
    ```
    The REPL prompt, `shadow.user=>`, indicates that is a Clojure REPL, not ClojureScript.

2. In the REPL, switch the session to this project's running build id, `:app`:
    ```clj
    (shadow.cljs.devtools.api/nrepl-select :app)
    ```
    The REPL prompt changes to `cljs.user=>`, indicating that this is now a ClojureScript REPL.
3. See [`user.cljs`](dev/cljs/user.cljs) for symbols that are immediately accessible in the REPL
without needing to `require`.{{#test?}}

### Running Tests

Build the app with the `prod` profile, start a temporary local web server, launch headless
Chrome/Chromium, run tests, and stop the web server:

```sh
lein karma
```

Please be patient; it may take over 15 seconds to see any output, and over 25 seconds to complete.{{/test?}}{{#garden?}}

### Compiling CSS with `lein-garden`

Use Clojure and [Garden](https://github.com/noprompt/garden) to edit styles in `.clj` files located
in the [`src/clj/{{sanitized}}/`](src/clj/{{sanitized}}/) directory. CSS files are compiled
automatically on [`dev`](#running-the-app) or [`prod`](#production) build.

Manually compile CSS files:
```sh
lein garden once
```

The `resources/public/css/` directory is created, containing the compiled CSS files.

#### Compiling CSS with Garden on change

Enable automatic compiling of CSS files when source `.clj` files are changed:
```sh
lein garden auto
```{{/garden?}}{{#less?}}

### Compiling CSS with `lein-less`

Use [Less](http://lesscss.org/features/) to edit styles in `.less` files located in the
[`less/`](less/) directory. CSS files are compiled automatically on [`dev`](#running-the-app)
or [`prod`](#production) build.

Manually compile CSS files:
```sh
lein less once
```

The `resources/public/css/` directory is created, containing the compiled CSS files.

#### Compiling CSS with `lein-less` on change

Enable automatic compiling of CSS files when source `.less` files are changed:
```sh
lein less auto
```{{/less?}}{{#scss?}}

### Compiling CSS with `lein-scss`

Use [Scss](https://sass-lang.com/) to edit styles in `.scss` files located in the
[`scss/`](scss/) directory. CSS files are compiled automatically on [`dev`](#running-the-app)
or [`prod`](#production) build.

Manually compile CSS files:
```sh
lein scss once
```

The `resources/public/css/` directory is created, containing the compiled CSS files.

#### Compiling CSS with `lein-scss` on change

Enable automatic compiling of CSS files when source `.scss` files are changed:
```sh
lein scss :dev auto
```{{/scss?}}

Substitute :dev for :prod when generating your final build.

### Running `shadow-cljs` Actions

See a list of [`shadow-cljs CLI`](https://shadow-cljs.github.io/docs/UsersGuide.html#_command_line)
actions:
```sh
lein run -m shadow.cljs.devtools.cli --help
```

Please be patient; it may take over 10 seconds to see any output. Also note that some actions shown
may not actually be supported, outputting "Unknown action." when run.

Run a shadow-cljs action on this project's build id (without the colon, just `app`):
```sh
lein run -m shadow.cljs.devtools.cli <action> app
```
### Debug Logging

The `debug?` variable in [`config.cljs`](src/cljs/{{sanitized}}/config.cljs) defaults to `true` in
[`dev`](#running-the-app) builds, and `false` in [`prod`](#production) builds.

Use `debug?` for logging or other tasks that should run only on `dev` builds:

```clj
(ns {{ns-name}}.example
  (:require [{{ns-name}}.config :as config])

(when config/debug?
  (println "This message will appear in the browser console only on dev builds."))
```

## Production

Build the app with the `prod` profile:{{^handler?}}

```sh
lein prod
```

Please be patient; it may take over 15 seconds to see any output, and over 30 seconds to complete.{{/handler?}}{{#handler?}}

```sh
lein with-profile prod uberjar
```

Please be patient; it may take a few seconds to see any output, and over 50 seconds to complete.{{/handler?}}

The `resources/public/js/compiled` directory is created, containing the compiled `app.js` and
`manifest.edn` files.{{#handler?}} The `target/` directory is then created, containing the
standalone `{{name}}.jar`.

### Running the Server

[Run the jar](https://github.com/ring-clojure/ring/wiki/Setup-for-production#run-the-server),
setting the port the Ring server will use by setting the environment variable, `port`.

```sh
port=2000 java -jar target/{{name}}.jar
```

If `port` is not set, the server will run on port 3000 by default.

### Deploying to Heroku

1. [Create a Heroku app](https://devcenter.heroku.com/articles/creating-apps):
    ```sh
    heroku create
    ```

2. [Deploy the app code](https://devcenter.heroku.com/articles/git#deploying-code):

    ```sh
    git push heroku master
    ```{{/handler?}}{{^handler?}}

The [`resources/public`](resources/public/) directory contains the complete, production web front
end of your app.

Always inspect the `resources/public/js/compiled` directory prior to deploying the app. Running any
`lein` alias in this project after `lein dev` will, at the very least, run `lein clean`, which
deletes this generated directory. Further, running `lein dev` will generate many, much larger
development versions of the files in this directory.{{/handler?}}
