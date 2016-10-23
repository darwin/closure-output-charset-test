(require '[cljs.build.api :as b]
         '[clojure.java.shell :refer [sh]])

(println "Building ...")

(let [start (System/nanoTime)]
  (sh "rm" "-rf" "out/dev_utf8")
  (b/build "src"
           {:main       'closure-output-charset.core
            :output-to  "out/dev_utf8/closure_output_charset.js"
            :output-dir "out/dev_utf8"
            :verbose    true})
  (sh "rm" "-rf" "out/dev_ascii")
  (b/build "src"
           {:main                   'closure-output-charset.core
            :output-to              "out/dev_ascii/closure_output_charset.js"
            :output-dir             "out/dev_ascii"
            :closure-output-charset "US-ASCII"
            :verbose                true})
  (sh "rm" "-rf" "out/adv_utf8")
  (b/build "src"
           {:main          'closure-output-charset.core
            :output-to     "out/adv_utf8/closure_output_charset.js"
            :output-dir    "out/adv_utf8"
            :optimizations :advanced
            :verbose       true})
  (sh "rm" "-rf" "out/adv_ascii")
  (b/build "src"
           {:main                   'closure-output-charset.core
            :output-to              "out/adv_ascii/closure_output_charset.js"
            :output-dir             "out/adv_ascii"
            :optimizations          :advanced
            :closure-output-charset "US-ASCII"
            :verbose                true})
  (println "... done. Elapsed" (/ (- (System/nanoTime) start) 1e9) "seconds"))
