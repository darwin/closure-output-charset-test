(require '[cljs.build.api :as b])

(b/watch "src"
  {:main 'closure-output-charset.core
   :output-to "out/closure_output_charset.js"
   :output-dir "out"})
