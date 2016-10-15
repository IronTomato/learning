console.log('content.js loaded');
chrome.runtime.sendMessage("hello----");
window.postMessage("hello++++","*");