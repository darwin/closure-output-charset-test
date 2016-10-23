# closure-output-charset

To build all variants

    ./scripts/build
    
To serve

    python -m SimpleHTTPServer

To prove that `:closure-output-charset` is effective:

    diff out/adv_ascii/closure_output_charset.js  out/adv_utf8/closure_output_charset.js
    
Or search for `"!BUG1704"` towards the end of the file. Both files should differ, ascii version will have escaped unicode
characters and utf8 variant will have the string inlined as raw unicode bytes.
