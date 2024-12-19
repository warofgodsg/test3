/**	2024.11.20
 *  공통함수 
 */

		function transferData(url, data){
			fetch(url, {
				method: "POST",
				headers: {'Accept': 'application/json',
				      'Content-Type': 'application/json'},
				body: data
			})
			.then((response) => console.log(response.json()))
			.catch((error) => console.log("error", error));
	
	
		}
		
		function trasferData2(url, data){
			$.ajax({
				type:'post',
				url: url,
				data: data,
				dataType:'json',
				success: function(response){
					console.info(response);
				}
				
			})
		}
	
		function floatValue(obj){
		      	var arr = [];
		      	for(let key in obj){
		      		var data = obj[key];
		      		var first_key = Object.keys(data)[0];
		      		arr.push( parseFloat(data[first_key]));
		      	}
		      	return arr;
		      }
		      
		function stringValue(obj){
		      	var arr = [];
		      	for(let key in obj){
		      		var data = obj[key];
		      		var first_key = Object.keys(data)[0];
		      		arr.push( data[first_key]);
		      	}
		      	return arr;
		      }        
		  function setTime(id){
		             var value = "";
		             var temp = "";
		             for(var i=0; i < 24; i++){
		                 for(var j=0; j<60; j+=10 ){
		                     temp = "";
		                     if(i < 10){
		                         temp += "0" + i + ":";
		                     }else temp += i + ":";
		                     if(j < 10){
		                         temp += "0" + j;
		                     }else temp += j;
		                     value += "<option value=" + temp + ">" + temp + "</option>";
		                 }
		             }
		             $("#"+id).append(value);
		         }

		         function cal_date(day){
		                 var today = new Date();
		                 var dday = new Date(today.setDate(today.getDate() + day));
		                 var dday_year;
		                 var dday_month;
		                 var dday_day;
		                     dday_year = dday.getFullYear();
		                 if(dday.getMonth() + 1 < 10){
		                     dday_month = '0' + (dday.getMonth()+1);  
		                 }else dday_month = dday.getMonth()+1;
		                 if(dday.getDate()< 10){
		                     dday_day = '0' + dday.getDate();  
		                 }else dday_day = dday.getDate();
		             
		                 return dday_year + '-' + dday_month + '-' + dday_day;
		             }
		         //그래프
		         function create_chart(cont, options, data, ht){

		             var obj =  { width: "100%", height: ht };

		                 obj["cont"] = cont;
		                 obj["id"] = cont;

		             var myChart = IBChart(obj);
		                 myChart.setOptions(options);
		                 myChart.loadSearchData(data, {
		                     append: true,
							 redraw: true
		                 });
		             window[obj["id"]] = myChart;
		         }


		         function create_chart02(cont, options, data){
		             var ib = ib||{};
		             ib = {
		             'create':function () {
		                 createIBChart(cont, "myChart", {
		                     width: "100%",
		                     height: "400px"
		                     });
		                     myChart.setOptions(options);
		                     this.doAction();
		                 },
		             //데이터 로드
		             'doAction':function() {
		                 myChart.loadSearchData(data, {
		                     append: true
		                 });
		                 }
		             };
		             ib.create();
		         }            

		         //복합그래프
		         function create_chart03(cont, options, data, ht){

		             var obj =  { width: "100%", height: ht };

		             obj["cont"] = cont;
		             obj["id"] = cont;
		             var myChart = IBChart(obj);
		             myChart.setOptions(options);
		             myChart.draw();
		             // myChart.loadSearchData(data, {
		             //     append: true
		             // });


		         } 
		         function create_chart04(cont, data){
		             var ib = ib||{};
		             console.info(data);
		             var options = options03(data.data00, data.data01, data.data02);
		             ib = {
		             'create':function () {
		                 createIBChart(cont, "myChart", {
		                     width: "100%",
		                     height: "400px"
		                     });
		                     myChart.setOptions(options);
		                     this.doAction();
		                 },
		             //데이터 로드
		             'doAction':function() {
		                 myChart.draw();
		                 }
		             };
		             ib.create();
		         } 		  