# closure-output-charset

To build all variants

    ./scripts/build
    
To serve

    python -m SimpleHTTPServer

To prove that `:closure-output-charset` is effective:

    diff out/adv_ascii/closure_output_charset.js  out/adv_utf8/closure_output_charset.js
    
Or search for `"!BUG1704"` towards the end of the file. Both files should differ, ascii version will have escaped unicode
characters and utf8 variant will have the string inlined as raw unicode bytes.

Response headers for `http://localhost:8000/out/adv_utf8/closure_output_charset.js` under Chrome 56.0.2899.0/macOS 10.12 were

    HTTP/1.0 200 OK
    Server: SimpleHTTP/0.6 Python/2.7.10
    Date: Sun, 23 Oct 2016 19:06:34 GMT
    Content-type: application/javascript
    Content-Length: 591850
    Last-Modified: Sun, 23 Oct 2016 19:00:55 GMT

So there is no need to specify some special UTF-8 content type.

Browser didn't complain even although the js file is technically broken UTF-8 (as separate issue caused by the [BUG 1704](https://github.com/google/closure-compiler/issues/1704)) 

