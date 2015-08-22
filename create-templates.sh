#!/bin/bash

rm -r temp
mkdir temp
cd temp

echo creating base
lein new re-frame base
cd base
lein cljsbuild once min
cd resources/public
google-chrome index.html
cd ../../..


echo creating base +routes
lein new re-frame base-routes +routes
cd base-routes
lein cljsbuild once min
cd resources/public
google-chrome index.html
cd ../../..

echo creating base +re-com
lein new re-frame base-recom +re-com
cd base-recom
lein cljsbuild once min
cd resources/public
google-chrome index.html
cd ../../..

echo creating base +test
lein new re-frame base-test +test
cd base-test
lein cljsbuild once min
lein cljsbuild once test
cd resources/public
google-chrome index.html
cd ../../..


echo creating base +routes +re-com
lein new re-frame base-routes-recom +routes +re-com
cd base-routes-recom
lein cljsbuild once min
cd resources/public
google-chrome index.html
cd ../../..

echo creating base +routes +test
lein new re-frame base-routes-test +routes +test
cd base-routes-test
lein cljsbuild once min
lein cljsbuild once test
cd resources/public
google-chrome index.html
cd ../../..

echo creating base +re-com +test
lein new re-frame base-recom-test +re-com +test
cd base-recom-test
lein cljsbuild once min
lein cljsbuild once test
cd resources/public
google-chrome index.html
cd ../../..


echo creating base +routes +re-com +test
lein new re-frame base-routes-recom-test +routes +re-com +test
cd base-routes-recom-test
lein cljsbuild once min
lein cljsbuild once test
cd resources/public
google-chrome index.html
cd ../../..
