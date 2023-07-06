const common = new Vue({
//  el: "#common",
  data: {
  },
  methods: {
      postExcute: function(url,param){
    	  console.log("1111 > " + url+" : "+param);
    	  this.outList = [];
    	  axios.post(url, param, {
				headers: { "Content-Type": "application/json"}
    	  }).then((res) => { 
        	$(".odd").html("");
            this.outList = res.data.result; 
            console.log("222222 > " + this.outList+" : ");
            if(this.outList.length > 0){
                pagination.common.totalCount = this.outList[0].totCnt;
                pagination.pagingNavi(pagination.common, this);
            }
            
//	                const newObj = _.cloneDeep(this.stockInOutList);
//	                this.stockInOutListCopy = newObj; 
//	                this.checkVal = [];
            //console.log("33333333333333333 > " + this.stockInOutListCopy[1].menuNm+" : "+checkVal);
    	  }).catch((ex) => { 
            console.log("에러", ex); 
    	  });
      },
      /**
	   * 이미지 파일 업로드
	   */
      fileExcute: function(url, file, editor){
	  	data = new FormData();
	  	data.append("file", file);
	  	$.ajax({
	  		data : data,
	  		type : "POST",
	  		url : url,
	  		contentType : false,
	  		processData : false,
	  		success : function(data) {
	          	//항상 업로드된 파일의 url이 있어야 한다.
	  			editor.summernote("insertImage", data.url);
	  		},
	  		error: function (jqXHR, textStatus, errorThrown) {
	            console.error(textStatus + " " + errorThrown);
	        }
	  	});
      }
  }
});
