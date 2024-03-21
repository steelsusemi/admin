/*import axios from 'axios'*/

var reqHeaderOptions = {
    headers: {
          "Content-Type": "application/json"
        , timeout: 60000
    }
};

const common = new Vue({
//  el: "#common",
  data: {
  },
  methods: {
	  // ajax post
      getPostExcute: function (callUrl, postData){
          return axios.post(callUrl, postData, reqHeaderOptions);
          			/*	.then((result) => {
			              succ(result.data.result, this);
			          }).catch(e => {
			              console.log("######## 에러[fail] ######## ");
			              // console.log(e);
			              // console.log(this);
			          });
			          */
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

function convertFormToJSON(form) {
	return form
		.serializeArray()
    	.reduce(function (json, { name, value }) {
    		json[name] = value;
    		return json;
    	}, {});
}