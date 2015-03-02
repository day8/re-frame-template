(ns {{name}}.dev
    (:require [{{name}}.core :as {{name}}]
              [figwheel.client :as fw]))

(fw/start {:on-jsload {{name}}/run
           :websocket-url "ws://localhost:3449/figwheel-ws"})
