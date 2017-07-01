var jsWaitBoxHome = new Object();
jsWaitBoxHome.Box = function(boxId, messageBoxId) {
    this.waitBox = document.getElementById(boxId);
    if (!this.waitBox) throw new "Box not found by id [" + boxId + "]" ;
    if (messageBoxId) {
        this.messageBox = document.getElementById(messageBoxId);
        if (!this.messageBox) throw new "Message box not found by id [" + messageBoxId + "]" ;
    } else {
        this.messageBox = null ;
    }
    this.show = jsWaitBoxHome._showBox_ ;
    this.hide = jsWaitBoxHome._hideBox_ ;
    this.onresize = jsWaitBoxHome._onresize_ ;
    this.showCount = 0 ;
    return this ;
}
jsWaitBoxHome._showBox_ = function() {
    if (this.showCount == 0) {
        with (this.waitBox.style) {
            visibility = 'visible' ;
            zIndex = 100 ;
        }
        this._preventDocumentActions(document);
//        jsEvent.add(window, "resize", this.onresize, true);
        this.onresize();
    }
    this.showCount ++ ;
}
jsWaitBoxHome._preventDocumentActions = function(doc) {
//    jsEvent.add(doc, "keydown", this.preventFocusChange, true);
//    jsEvent.add(doc, "keypress", this.preventFocusChange, true);
    var frames = doc.frames ? doc.frames : doc.getElementsByTagName("IFRAME");
    for (var i = 0, l = frames.length ; i < l ; i ++) {
        var frame = frames[i] ;
        if (frame.contentDocument || frame.document)
            this._preventDocumentActions(frame.contentDocument || frame.document);
    }
}
jsWaitBoxHome._hideBox_ = function() {
    if (this.showCount == 1) {
        with (this.waitBox.style) {
            visibility = 'hidden' ;
            zIndex = -1 ;
        }
        this._removePreventDocumentActions(document);
//        jsEvent.remove(window, "resize", this.onresize, true);
    }
    this.showCount -- ;
}
jsWaitBoxHome._removePreventDocumentActions = function(doc) {
//    jsEvent.remove(doc, "keydown", this.preventFocusChange, true);
//    jsEvent.remove(doc, "keypress", this.preventFocusChange, true);
    var frames = doc.frames ? doc.frames : doc.getElementsByTagName("IFRAME");
    for (var i = 0, l = frames.length ; i < l ; i ++) {
        var frame = frames[i] ;
        if (frame.contentDocument || frame.document)
            this._removePreventDocumentActions(frame.contentDocument || frame.document);
    }
}
jsWaitBoxHome._onresize_ = function() {
    var clientHeight = (document.documentElement && document.documentElement.clientHeight) ? document.documentElement.clientHeight :
                       (document.body && document.body.clientHeight) ? document.body.clientHeight : window.innerHeight ;
    var clientWidth = (document.documentElement && document.documentElement.clientWidth) ? document.documentElement.clientWidth :
                      (document.body && document.body.clientWidth) ? document.body.clientWidth : window.innerWidth ;
    with (this.waitBox.style) {
        width = clientWidth - (document.all ? 0 : 0) + "px" ;
        height = clientHeight - (document.all ? 3 : 0) + "px" ;
        if (this.messageBox) with (this.messageBox.style) {
            top = clientHeight / 2 - this.messageBox.offsetHeight / 2 + "px" ;
            left = clientWidth / 2 - this.messageBox.offsetWidth / 2 + "px" ;
        }
    }
}