const pagination = new Vue({
//  el: "#pagination",
  data: {
	  common: {
		  totalCount: 0,
		  pageSize: 10,
		  navPage: 10,
		  currentPage: 1,
		  curPage: 0,
	  },
	  elId: ``,
	  selectOk: false  
  },
  methods: {
      setMove: function(curPage){
//      	console.log("curPage >> " +curPage);
      	this.common.currentPage = curPage;
      	this.common.curPage = this.common.pageSize * (curPage - 1);	// mariadb
      	this.elId.getSearch();
      },
      pagingNavi: function(pageInfo, el){
    	this.elId = el;
    	
      	const totalPage = Math.ceil(this.common.totalCount / pageInfo.pageSize);	// 총 페이지 수
      	const pageGroup = Math.ceil(pageInfo.currentPage / pageInfo.navPage);			// 페이지 그룹
      	
      	let last = pageGroup * pageInfo.navPage;	// 화면에 보여질 마지막 페이지 번호
      	if(last > totalPage){
      		last = totalPage;
      	}
      	
      	const first = last - (pageInfo.navPage - 1) < 0 ? 1 : last - (pageInfo.navPage - 1); // 화면에 보여질 첫번째 페이지 번호
      	
      	const forFront = 1;
      	const prev = (pageInfo.currentPage - 1);
      	const next = pageInfo.currentPage + 1;
      	const rearMost = totalPage;
      	
      	console.log("totalPage >> " +totalPage);
      	console.log("pageGroup >> " +pageGroup);
      	console.log("forFront >> " +forFront);
      	console.log("first >> " +first);
      	console.log("prev >> " +prev);
      	console.log("pageInfo.currentPage >> " +pageInfo.currentPage);
      	console.log("next >> " +next);
      	console.log("last >> " +last);
      	console.log("rearMost >> " +rearMost);
      	
      	let innerHtml = "";
      	const selBoolean = true;
      	
      	innerHtml += "	<div class='dataTables_paginate paging_simple_numbers'>";
      	innerHtml += "		<ul class='pagination'>";
      	
      	// 맨앞, 이전 Set
      	if(prev > 0){
      		selBoolean ? innerHtml += "<li class='paginate_button previous'><a href='#' onClick='setMove("+forFront+")' aria-controls='datatable-checkbox' data-dt-idx='0' tabindex='0'> << </a></li>" : innerHtml += "";
      		innerHtml += "<li class='paginate_button previous'><a href='#' onClick='setMove("+prev+")' data-dt-idx='"+prev+"' aria-controls='datatable-checkbox'>Previous</a></li>";
      	}
      	
      	// 페이지 Set
      	for(let i=first; i<=last; i++){
	        	if(pageInfo.currentPage === i){
	        		innerHtml += "<li class='paginate_button active'><a href='#' onClick='setMove("+i+")' aria-controls='datatable-checkbox' data-dt-idx='"+i+"' style='font-weight: bold;'>"+i+"</a></li>";
	        	}else{
	        		innerHtml += "<li class='paginate_button'><a href='#' onClick='setMove("+i+")' aria-controls='datatable-checkbox' data-dt-idx='"+i+"' tabindex='0'>"+i+"</a></li>";
	        	}
      	}
      	
      	// 다음, 맨뒤 Set
      	if(pageInfo.currentPage < totalPage || last < totalPage){
      		innerHtml += "<li class='paginate_button next'><a href='#' onClick='setMove("+next+")' data-dt-idx='"+next+"' aria-controls='datatable-checkbox'>Next</a></li>";
      		selBoolean ? innerHtml += "<li class='paginate_button next'><a href='#' onClick='setMove("+rearMost+")' aria-controls='datatable-checkbox' data-dt-idx='"+rearMost+"' tabindex='0'> >> </a></li>" : innerHtml += "";
      	}
      	innerHtml += "		</ul>";
      	innerHtml += "	</div>";
      	/*innerHtml += "</div>";*/
      	
      	// 페이지 생성
      	this.elId.$refs.paging.innerHTML = innerHtml;
      },
      onChange: function(val, firstSeq){
		console.log("val > " + val+" : " + firstSeq+" : " + this.common.totalCount+" : " + (firstSeq / val)+" : " + (pagination.common.pageSize > val ? 1 : -1));
    	this.common.currentPage = Math.ceil((firstSeq / val));
		this.common.curPage = val * (this.common.currentPage - 1);	// mariadb
		console.log("val > " + val+" : " + firstSeq+" : " + (firstSeq / val)+" : " + Math.ceil((firstSeq / val)));
		this.common.pageSize = val;
		return true;
      }
  }
});

// 페이지 이동
setMove = function (pageNum){
//	console.log("setMove > " + pageNum);
	pagination.setMove(pageNum);
}
