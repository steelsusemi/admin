const common = new Vue({
  el: "#common",
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
      }
  }
});
