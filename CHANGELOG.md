## Unreleased

## 2.3.1 (2021-07-21)

#### Changed

- Upgrade shadow-cljs to [2.15.2](https://github.com/thheller/shadow-cljs/blob/master/CHANGELOG.md#2152).

## 2.3.0 (2021-07-14)

#### Added

- Add 'npm run ancient' as an alias for [antq](https://github.com/liquidz/antq). Requires `clojure` CLI tools.

#### Changed

- Upgrade shadow-cljs to [2.15.1](https://github.com/thheller/shadow-cljs/blob/master/CHANGELOG.md#2151)
- Upgrade karma to 6.3.4
- Upgrade cider-nrepl to 0.26.0

## 2.2.7 (2021-07-07)

#### Changed

- Upgrade shadow-cljs to [2.14.6](https://github.com/thheller/shadow-cljs/blob/master/CHANGELOG.md#2146)
- Upgrade pushy to 0.3.10
- Upgrade re-frame-10x to 1.1.10

## 2.2.6 (2021-06-22)

#### Changed

- Upgrade re-frame-10x to 1.1.7. Fixes [several bugs](https://github.com/day8/re-frame-10x/blob/master/CHANGELOG.md#117-2021-06-22);

## 2.2.5 (2021-06-20)

#### Changed

- Upgrade re-frame-10x to 1.1.4
- Upgrade reagent to 1.1.0
- Upgrade shadow-cljs to [2.14.5](https://github.com/thheller/shadow-cljs/blob/master/CHANGELOG.md#2145)

## 2.2.4 (2021-05-27)

#### Fixed

- Fix hot code reloading breaking navigation with `+routes` option.
See [#163](https://github.com/day8/re-frame-template/issues/163).
Thanks to [@Sose](https://github.com/Sose).

## 2.2.3 (2021-05-18)

#### Fixed

- Fix `+test` shadow-cljs `karma-test` and `browser-test` configs.
  See [#159](https://github.com/day8/re-frame-template/pull/159).
  Thanks to [@ertugrulcetin](https://github.com/ertugrulcetin).
- Fix styles.cljs path in generated `README.md`.
  Thanks to [@aaronshim](https://github.com/aaronshim).
- Fix fallback to `index.html`. See [#161](https://github.com/day8/re-frame-template/issues/161).
  Thanks to [@mattdamon108](https://github.com/mattdamon108).

## 2.2.2 (2021-04-28)

#### Changed

- Upgrade re-frisk to 1.5.1. Fixes [flexsurfer/re-frisk#63](https://github.com/flexsurfer/re-frisk/issues/63).
Thanks to [@flexsurfer](https://github.com/flexsurfer).

## 2.2.1 (2021-04-20)

#### Changed

- Upgrade re-frisk to 1.5.0

## 2.2.0 (2021-04-17)

#### Removed

- Remove broken `+calva` option as Calva has built in support for pure shadow-cljs projects.
Fixes [#155](https://github.com/day8/re-frame-template/issues/155) and
[BetterThanTomorrow/calva#1121](https://github.com/BetterThanTomorrow/calva/issues/1121).
Addresses [BetterThanTomorrow/calva#314](https://github.com/BetterThanTomorrow/calva/issues/314). Thanks to [@PEZ](https://github.com/PEZ).

#### Changed

- Upgrade shadow-cljs to [2.12.5](https://github.com/thheller/shadow-cljs/blob/master/CHANGELOG.md#2125)
- Upgrade karma to 6.3.2

## 2.1.2 (2021-04-13)

#### Changed

- Upgrade shadow-cljs to [2.12.4](https://github.com/thheller/shadow-cljs/blob/master/CHANGELOG.md#2124)
- Upgrade re-frisk to 1.4.0
- Upgrade cider-nrepl to 0.25.11

## 2.1.1 (2021-04-06)

#### Changed

- Move `:preloads` to `:devtools` to align with current [shadow-cljs documentation](https://shadow-cljs.github.io/docs/UsersGuide.html#_preloads)

## 2.1.0 (2021-04-06)

#### Changed

- Upgrade to shadow-cljs 2.12.1 (includes [ClojureScript 1.10.844](https://github.com/clojure/clojurescript/blob/master/changes.md#110844)).
- Upgrade karma to 6.3.0

## 2.0.5 (2021-04-05)

#### Changed

- Upgrade shadow-git-inject to 0.0.5

## 2.0.4 (2021-04-01)

#### Changed

- Upgrade shadow-git-inject to 0.0.4

## 2.0.3 (2021-04-01)

#### Changed

- Upgrade shadow-git-inject to 0.0.3

## 2.0.2 (2021-03-31)

#### Fixed

- Fix `+git-inject` option build hook configuration in `shadow-cljs.edn`.
Thanks to [@thheller](https://github.com/thheller) for reporting the issue and fix.

## 2.0.1 (2021-03-31)

#### Fixed

- Fix deprecated usage of `:devtools` in `shadow-cljs.edn` by using `:dev-http` instead.
Thanks to [@thheller](https://github.com/thheller) for reporting the issue and fix.

## 2.0.0 (2021-03-31)

**BREAKING CHANGES:** `+handler` and `+less` options have been removed.

**MAJOR COMMAND CHANGES:**` After creating your templated project instead of:
- `lein watch` now use `npm run watch`
- `lein shadow ...` now use `npx shadow-cljs ...`
- `lein release` now use `npm run release`

#### Changed

- Replace lein with shadow-cljs. Leiningen is still used for templating (i.e. `lein new re-frame ...`), but the resulting
output is now a pure shadow-cljs build with no dependency on Leiningen. This resolves a whole class of bugs and beginner
confusion that was being caused by the more complex Leiningen setup. It also enables users to have a `npm` or `yarn`
focused workflow for dependencies, as we no longer wrap those tools.

#### Removed

- Remove `+handler` option. Due to change from Leiningen to pure shadow-cljs. This is a client-focused template, and
it is not worthwhile for us to maintain a backend implementation when there are other templates focused on that use
case. We will not re-add this option.
- Remove `+less` option. Due to change from Leiningen to pure shadow-cljs. We might be amenable to re-adding this
if/when a shadow-cljs build hook for less is available.

## 1.5.0 (2021-03-23)

#### Changed

- Upgrade re-frame-10x to 1.0.2. Fixes [#150](https://github.com/day8/re-frame-template/issues/150).
- Upgrade re-frame tracing to 0.6.2
- Upgrade shadow-cljs to [2.11.24](https://github.com/thheller/shadow-cljs/blob/master/CHANGELOG.md#21124)
- Upgrade re-frisk to 1.3.12
- Upgrade karma to 6.2.0
- Upgrade ring to 1.9.2

#### Added

- Add `+git-inject`

## 1.4.2 (2021-03-08)

#### Changed

- Change to bidi and pushy for `+routes`
- Upgrade karma 6.1.1
- Upgrade shadow-cljs 2.11.21
- Upgrade re-frame-10x to 1.0.1
- Upgrade Clojure to 1.10.3

## 1.4.1 (2021-03-05)

#### Fixed

- Fix cider integration. See [#148](https://github.com/day8/re-frame-template/issues/148). Thanks to [@MrSFGriffin](https://github.com/MrSFGriffin).

## 1.4.0 (2021-02-25)

#### Changed

- Upgrade re-frame to 1.2.0
- Upgrade re-frame-10x to 1.0.0
- Upgrade re-com to 2.13.2
- Upgrade reagent to 1.0.0
- Upgrade shadow-cljs to 2.11.18
- Upgrade Clojure to 1.10.2
- Upgrade ring to 1.9.1

## 1.3.1 (2020-11-11)

#### Fixed

- Fix uberjar target, +handler profile and Heroku instructions. Thanks to
  [@dominem](https://github.com/dominem) and [@paulbutcher](https://github.com/paulbutcher).
  See [#139](https://github.com/day8/re-frame-template/pull/139) and [#145](https://github.com/day8/re-frame-template/pull/145).

#### Changed

- Upgrade [re-frame to 1.1.2](http://day8.github.io/re-frame/)
- Upgrade shadow-cljs to 2.11.7
- Upgrade ring to 1.8.2

## 1.3.0 (2020-09-28)

#### Changed

- Upgrade [lein-shadow to 0.3.1](https://gitlab.com/nikperic/lein-shadow/-/blob/master/CHANGELOG.md#030-2020-09-22)
- Upgrade shadow-cljs to 2.11.4
- Upgrade karma to 5.2.3

## 1.2.4 (2020-09-04)

#### Fixed

- Fix exception in `server.clj` when port is given from environment. See #140

#### Changed

- Upgrade [karma to 5.2.1](https://github.com/karma-runner/karma/blob/master/CHANGELOG.md#521-2020-09-02)

## 1.2.3 (2020-08-26)

#### Changed

- Upgrade [re-frame to 1.1.1](http://day8.github.io/re-frame/releases/2020/#110-2020-08-24)

## 1.2.2 (2020-08-25)

#### Changed

- Upgrade [lein-shadow to 0.2.2](https://gitlab.com/nikperic/lein-shadow/-/blob/master/CHANGELOG.md#022-2020-08-07)
- Upgrade [shadow-cljs to 2.11.0](https://github.com/thheller/shadow-cljs/commit/28169be104149e496b31bad443be7ecb6d16cd4a)
- Upgrade [re-frame to 1.1.0](http://day8.github.io/re-frame/releases/2020/#110-2020-08-24)
- Upgrade re-com to 2.9.0
- Upgrade karma to 5.1.1
- Upgrade compojure to 1.6.2

## 1.2.1 (2020-08-05)

#### Fixed

- Fix karma lein aliases on Windows

#### Changed

- Rename lein aliases to align with shadow-cljs terminology. Prints deprecated
  warning on use of old aliases so that it is not yet a breaking change. Old
  aliases will be removed in a future release.
- Change `lein watch` (previously, `lein dev`) to watch all builds including
  the browser and karma test runners instead of just the application.
- Upgrade shadow-cljs to 2.10.19

## 1.2.0 (2020-07-21)

#### Changed

- Upgrade re-frame to 1.0.0
- Upgrade shadow-cljs to 2.10.17

## 1.1.4 (2020-07-16)

#### Changed

- Upgrade re-frame-10x to 0.7.0
- Upgrade re-frisk to 1.3.4
- Upgrade re-frame-tracing to 0.6.0

## 1.1.3 (2020-06-30)

#### Changed

- Upgrade [re-frame-tracing to 0.5.6](https://github.com/day8/re-frame-debux/blob/master/CHANGELOG.md)
- Upgrade re-frame-10x to 0.6.6
- Upgrade binaryage/devtools to 1.0.2
- Upgrade ClojureScript 1.10.773
- Upgrade shadow-cljs to 2.10.13

## 1.1.2 (2020-05-27)

#### Added

- Add Calva support. See [#132](https://github.com/day8/re-frame-template/pull/132).
  Thanks to [@PEZ](https://github.com/PEZ).

## 1.1.1 (2020-05-15)

#### Changed

- Upgrade re-frame-10x to [0.6.5](https://github.com/day8/re-frame-10x/blob/master/CHANGELOG.md#065---2020-05-15)

## 1.1.0 (2020-05-14)

#### Changed

- Upgrade ClojureScript to [1.10.764](https://github.com/clojure/clojurescript/blob/master/changes.md#110764)
- Raise minimum Leiningen version for the generated project to `2.9.0` or later. Older versions *might*
  work, but we don't test them, so we may as well specify a properly tested and supported version. The
  previous required minimum `2.5.3` is also 5 years old, so thats really old. The new minimum `2.9.0` is 
  1.25 years old already, so its reasonable.
- Upgrade shadow-cljs to 2.9.3

## 1.0.34 (2020-05-14)

#### Changed

- Upgrade `lein-shadow` to 0.2.0.
  See the [`lein-shadow` `CHANGELOG.md`](https://gitlab.com/nikperic/lein-shadow/-/blob/master/CHANGELOG.md)
  and [merge request](https://gitlab.com/nikperic/lein-shadow/-/merge_requests/3) for a full list of changes.
  See issues [#127](https://github.com/day8/re-frame-template/issues/127) and
  [#128](https://github.com/day8/re-frame-template/issues/128) for some of the background and ongoing
  discussion. Further changes to align with `shadow-cljs` and `npm` while maintaining a `lein`-focus may
  be forthcoming. Thanks to [@thheller](https://github.com/thheller) for his input.
- Upgrade secretary to 1.2.4. Fixes day8/re-frame#530. Thanks to [@JDurstberger](https://github.com/JDurstberger).
- Upgrade shadow-cljs to 2.9.2
- Upgrade re-frisk to 1.3.2

## 1.0.33 (2020-05-11)

#### Changed

- Upgrade shadow-cljs to 2.9.0

## 1.0.32 (2020-05-06)

#### Changed

- Upgrade ClojureScript to [1.10.758](https://github.com/clojure/clojurescript/blob/master/changes.md#110758)
- Upgrade shadow-cljs to 2.8.110
- Upgrade garden to 1.3.10
- Upgrade ring to 1.8.1

## 1.0.31 (2020-05-04)

#### Changed

- Upgrade re-frisk to 1.3.0

## 1.0.30 (2020-05-01)

#### Changed

- Use [lein-shadow](https://gitlab.com/nikperic/lein-shadow) and [ns aliases for tracing-stubs](https://github.com/day8/re-frame-debux/issues/30).
- Upgrade re-frame-10x to [0.6.4](https://github.com/day8/re-frame-10x/blob/master/CHANGELOG.md#064---2020-05-01)
- Upgrade re-frame-debux to 0.5.5

#### Fixed

- Fix use of deprecated reagent fns

## 1.0.29 (2020-04-30)

#### Fixed

- Fix missing clj-kondo config. See [#124](https://github.com/day8/re-frame-template/pull/124)

#### Changed

- Upgrade ClojureScript to [1.10.748](https://github.com/clojure/clojurescript/blob/master/changes.md)
- Upgrade shadow-cljs to 2.8.109
- Upgrade reagent to [0.10.0](https://github.com/reagent-project/reagent/blob/master/CHANGELOG.md#0100-2020-03-06)
- Upgrade re-frame to [0.12.0](https://github.com/day8/re-frame/blob/master/CHANGELOG.md#0120-2020-03-08)
- Upgrade re-com to [2.8.0](https://github.com/day8/re-com/blob/master/CHANGELOG.md#280-2020-03-08)
- Upgrade re-frame-10x to [0.6.3](https://github.com/day8/re-frame-10x/blob/master/CHANGELOG.md#063---2020-04-30)
- Upgrade re-frisk to 1.2.0
- Upgrade ring to [1.8.0](https://github.com/ring-clojure/ring/blob/master/CHANGELOG.md#180-2019-11-13)

## 1.0.28 (2020-02-14)

#### Changed

- Upgrade binaryage/devtools to 1.0.0
- Upgrade re-frame-10x to 0.5.1
- Upgrade re-com to 2.7.0

Overall these upgrades result in a consistent React version across all
dependencies of [16.9.0](https://reactjs.org/blog/2019/08/08/react-v16.9.0.html).

## 1.0.27 (2020-01-20)

#### Changed

- Upgrade reagent to 0.9.1
- Upgrade re-frame to 0.11.0

#### Fixed

- Some of the uberjar issues thanks to [Derek Passen](https://github.com/dpassen).
  See [#95](https://github.com/day8/re-frame-template/issues/95). 
- Add Garden/Less CSS compilation to build prep-tasks thanks to
  [@stevejmp](https://github.com/stevejmp).
- Add lein, node, shadow-cljs items to .gitignore thanks to
  [@stevejmp](https://github.com/stevejmp).

#### Added

- +kondo profile thanks to [@stevejmp](https://github.com/stevejmp).

#### Removed

- Remove clean from lein aliases to workaround [#95](https://github.com/day8/re-frame-template/issues/95).
- Unused test/cljs/runner.cljs thanks to [@stevejmp](https://github.com/stevejmp).
- Unused leiningen.new.options.helpers/invoke-option fn thanks to
  [@stevejmp](https://github.com/stevejmp).

## [1.0.26 (2019-12-18)](https://github.com/day8/re-frame-template/runs/352988356)

#### Fixed

- Fixed docs re lein aliases thanks to [@stevejmp](https://github.com/stevejmp)

#### Changed

- Upgrade shadow-cljs to 2.8.83
- Upgrade yogthos/config to 1.1.7

## [1.0.25 (2019-12-05)](https://github.com/day8/re-frame-template/runs/333630252)

#### Changed

- Upgrade shadow-cljs to 2.8.80

## [1.0.24 (2019-11-30)](https://github.com/day8/re-frame-template/runs/326469035)

#### Changed

- Upgrade shadow-cljs to 2.8.76
- Downgrade re-frame-10x to 0.4.4

#### Added

- Add org.clojure/google-closure-library-third-party exclusion to ClojureScript dependency

## [1.0.23 (2019-11-20)](https://github.com/day8/re-frame-template/runs/311234380)

#### Changed

- Upgrade [ClojureScript to 1.10.597](https://clojurescript.org/news/2019-11-18-release)
- Upgrade binaryage/devtools to 0.9.11
- Upgrade shadow-cljs to 2.8.73

## [1.0.22 (2019-11-02)](https://github.com/day8/re-frame-template/runs/285090579)

#### Changed

- Upgrade shadow-cljs to 2.8.69
- Upgrade re-frame-10x to 0.4.5
- Migrate to me.arrdem/lein-git-version 
- Migrate to GitHub Actions based continuous integration and continuous deployment

#### Added

- Add LICENSE. Maintains the same LICENSE (MIT) that has always been present in the README.md file. Just makes it more
  accessible and obvious.

## 1.0.21 (2019-10-30)

#### Changed

- Upgrade shadow-cljs to 2.8.68

## 1.0.20 (2019-10-24)

#### Added

- Add lein build-report alias
- Add clean to all lein aliases

#### Changed

- Rename lein karma-once alias to karma

#### Fixed

- Fix missing karma-junit-reporter dependency

## 1.0.19 (2019-10-24)

#### Changed

- Upgrade shadow-cljs to 2.8.67

## 1.0.18 (2019-10-22)

#### Changed

- Upgrade shadow-cljs to 2.8.65
- Upgrade karma to 4.4.1

## 1.0.17 (2019-10-18)

#### Fixed

- Import goog.history.EventType properly.
  See [#94](https://github.com/day8/re-frame-template/pull/94).
  Thanks to [@Wegi](https://github.com/Wegi).

#### Added

- Added lein karma-once alias

#### Changed

- Upgrade shadow-cljs to 2.8.64
- Upgrade yogthos/config to 1.1.6
- Upgrade karma to 4.4.0

## 1.0.16 (2019-10-15)

#### Changed

- Upgrade re-frame-10x to 0.4.4

## 1.0.15 (2019-10-11)

#### Changed

- Upgrade shadow-cljs to 2.8.62

## 1.0.14 (2019-10-09)

#### Changed

- Upgrade shadow-cljs to 2.8.61

## 1.0.13 (2019-09-27)

#### Changed

- Upgrade shadow-cljs to 2.8.59

## 1.0.12 (2019-09-25)

#### Changed

- Upgrade shadow-cljs to 2.8.58

## 1.0.11 (2019-09-25)

#### Changed

- Upgrade shadow-cljs to 2.8.57

## 1.0.10 (2019-09-24)

#### Changed

- Upgrade shadow-cljs to 2.8.56

## 1.0.9 (2019-09-22)

#### Changed

- Upgrade shadow-cljs to 2.8.55

## 1.0.8 (2019-09-20)

#### Changed

- Upgrade shadow-cljs to 2.8.53
- Upgrade re-com to 2.6.0
- Upgrade re-pressed to 0.3.1

## 1.0.7 (2019-09-11)

#### Changed

- Upgrade re-frame-10x to 0.4.3
- Upgrade lein-garden to 0.3.0

#### Removed

- Empty generated `core.clj` [#93](https://github.com/day8/re-frame-template/pull/93) 
  thanks to @thheller

## 1.0.6 (2019-08-28)

#### Changed

- Upgrade shadow-cljs to 2.8.52
- Upgrade re-frame to 0.10.9
- Upgrade karma to 4.3.0

## 1.0.5 (2019-08-24)

#### Fixed

- 1.0.4 introduced a regression whereby if the +10x profile was not used an
  extra bracket in `shadow-cljs.edn` would cause the build to fail. This is
  fixed in 1.0.5. See [#92](https://github.com/day8/re-frame-template/issues/92).

## 1.0.4 (2019-08-21)

#### Changed

- Greatly simplified shadow-cljs config thanks to @thheller
- Upgrade react-flip-move to 3.0.3. Fixes warning of depedency conflict with re-frame-10x.
- Upgrade karma-chrome-launcher to 3.1.0
- Upgrade to shadow-cljs 2.8.51

#### Fixed

- +cider profile adds -Xmx1G :jvm-opts as a workaround for Emacs cider-jack-in-cljs failure
  thanks to investigation and report by @Quezion

## 1.0.3 (2019-08-18)

#### Fixed

- Don't use unsafe version ranges in package.json

## 1.0.2 (2019-08-16)

#### Changed

- Upgrade shadow-cljs to 2.8.48

## 1.0.1 (2019-08-12)

#### Changed

- Upgrade shadow-cljs to 2.8.45

#### Removed

- Remove +gadfly profile

## 1.0.0 (2019-08-06)

#### Changed

- Migrate to shadow-cljs

## 0.3.23 (2019-07-15)

#### Changed

- Upgrade re-frame to 0.10.8

## 0.3.22 (2019-06-08)

#### Changed

- Upgrade compojure to 1.6.1
- Upgrade garden to 1.3.9
- Upgrade Clojure to 1.10.1
- Upgrade re-com to 2.5.0
- Upgrade re-pressed to 0.3.0
- Upgrade re-frame-10x to 0.4.0
- Upgrade ns-tracker to 0.4.0
- Upgrade re-frisk to 0.5.4.1
- Upgrade ring to 1.7.1
- Upgrade yogthos/config 1.1.2
- Upgrade figwheel-sidecar to 0.5.18
- Upgrade cider/piggieback to 0.4.1

## 0.3.20 (2019-03-12)

#### Fixed

- Ensure that .gitignore is created

## 0.3.19 (2019-03-11)

#### Changed

- Upgrade re-com to 2.4.0

#### Removed

- Transitive dependencies on cljs-time and core.async

## 0.3.18 (2019-03-11)

#### Changed

- Upgrade Clojure to 1.10.0
- Upgrade ClojureScript to 1.10.520
- Upgrade reagent to 0.8.1
- Upgrade re-frame to 0.10.6
