
//ajax查询（异步）
$.ajaxPost = function(url, param, callBack) {
    url = url + "?qryDate=" + new Date().getTime();
    $.ajax({ type : "post", url : url, dataType : "json" , data : param,
        success : function(data) {
            callBack(data);
        },
        error : function(data) {

            console.log(data);
        } });
}

//ajax查询（同步）
$.ajaxPostSync = function(url, param, callBack) {
    url = url + "?qryDate=" + new Date().getTime();
    $.ajax({ type : "post", url : url, dataType : "json" , data : param, async : false ,
        success : function(data) {
            callBack(data);
        },
        error : function(data) {

            console.log(data);
        } });
}

//ajax表单提交
$.ajaxForm = function(url, form, callBack) {
    url = url + "?qryDate=" + new Date().getTime();
    $.ajax({ type : "post", url : url, data : form, processData:false,contentType:false,dataType:"json", success : function(data) {
            callBack(data);
        },beforeSend:function(xhr){

        },
        complete:function(XHR, TS){

        },
        error : function(data) {
            console.log(data);
        } });
}

//填充所有页面
function fnShowFull(title,url){
    var index = layer.open({
        type : 2,
        title : title,
        content : url
    });
    layer.full(index);
}

function fnColseShow(){
    var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
    parent.layer.close(index);
}

//关闭弹出层
colseShowLayer = function(){
    //只能保留数字，2位小数
    $("body").delegate(".fnColseLay","click",function(){
        fnColseShow();
    });

}