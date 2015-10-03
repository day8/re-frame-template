var system = require('system');
var url,args;

if (phantom.version.major > 1) {
    args = system.args;
    if (args.length < 2) {
        system.stderr.write('Expected a target URL parameter.');
        phantom.exit(1);
    }
    url = args[1];
} else {
    args = phantom.args;
    if (args.length < 1) {
        system.stderr.write('Expected a target URL parameter.');
        phantom.exit(1);
    }
    url = args[0];
}

var page = require('webpage').create();

page.onConsoleMessage = function (message) {
    console.log(message);
};

function exit(code) {
    setTimeout(function(){ phantom.exit(code); }, 0);
    phantom.onError = function(){};
}

console.log("Loading URL: " + url);

page.open(url, function (status) {
    if (status != "success") {
        console.log('Failed to open ' + url);
        phantom.exit(1);
    }

    console.log("Running test.");

    var failures = page.evaluate(function() {
        test_runner.runner();
        return window["test-failures"];
    });

    if (failures == 0) {
        console.log("Tests succeeded.")
    }
    else {
        console.log("*** Tests failed! ***");
    }

    phantom.exit(failures?100:0);
});
