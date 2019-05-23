//分页工具
var pageHepler = {};

/**
 * 初始化分页变量
 */
pageHepler.initPagerView = function (initPramas,callback){
    var pagerView = new PagerView(initPramas.id);
    pagerView.index = initPramas.index || 1; // 当前是第3页
    pagerView.size = initPramas.size || 20; // 每页显示20条记录
    pagerView.itemCount = initPramas.itemCount || 100; // 一共有100条记录
    pagerView.onclick = callback;
    pageHepler.pagerView = pagerView;
}

/**
 * 分页操作
 */
pageHepler.render = function(pager, total, callback){
    var pagerView = pageHepler.pagerView;
    pagerView.index = pager.pageNo; // 当前是第3页
    pagerView.size = pager.pageSize; // 每页显示16条记录
    pagerView.itemCount = pager.totalCount; // 一共有100条记录
    pagerView.pageCount = pager.totalPage;
    pagerView.nextPage = 0;
    if(callback){//修改点击页标回调函数
        pagerView.onclick = callback;
    }
    pagerView.render();
}