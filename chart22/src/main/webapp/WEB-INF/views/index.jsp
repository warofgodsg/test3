<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chart</title>
    
    <!-- <link rel="stylesheet" href="js/jquery-ui.min.css">    
    <script src="js/jquery.js" type="text/javascript" > </script>
    <script src="js/jquery-ui.min.js" type="text/javascript" > </script>

    <script src="js/highcharts.js" type="text/javascript" > </script>
    <script src="js/ibleaders.js" type="text/javascript" > </script>
    <script src="js/ibchart.js" type="text/javascript" > </script>
    <script src="js/ibchartinfo.js" type="text/javascript" > </script>
    <script src="js/ibsheet.js" type="text/javascript" > </script>
    <script src="js/ibsheetinfo.js" type="text/javascript" > </script>

    <script src="js/data.js" type="text/javascript" > </script>
    <script src="js/options.js" type="text/javascript" > </script> -->


    <link rel="stylesheet" href="/js/jquery-ui.min.css">    
    <script src="/js/jquery.js" type="text/javascript" > </script>
    <script src="/js/jquery-ui.min.js" type="text/javascript" > </script>

    <script src="/js/highcharts.js" type="text/javascript" > </script>
    <script src="/js/ibleaders.js" type="text/javascript" > </script>
    <script src="/js/ibchart.js" type="text/javascript" > </script>
    <script src="/js/ibchartinfo.js" type="text/javascript" > </script>
    <script src="/js/ibsheet.js" type="text/javascript" > </script>
    <script src="/js/ibsheetinfo.js" type="text/javascript" > </script>


	<script src="/js/commonFunction.js" type="text/javascript" > </script>
    <script src="/js/data.js" type="text/javascript" > </script>
    <script src="/js/options.js" type="text/javascript" > </script>
    <style>
    	body{margin:0;padding:0;width:100%}
        .ui-menu { width: 15em; };
        #header {
            padding:0;
            margin:0;
            height:3em;
        }
        #wrapper{
        	padding:0;margin:0;
            padding-top:1.5em;
            position:absolute;
            width:100%;
            
        }
        input[type="text"]{
            padding:0.25em;
            border:1px solid #033;
            text-align: center;
        }
        select{
            padding:.2em;
            border: 1px solid #033;
            text-align: center;
        }
        .menu_panel{
            display: none; width:100%;
        }
        .panel_head{
            padding:.5em;background-color: #eee
        }
        .panel_head table{
       		border:1px solid #ccc;width: 100%;;padding:.5em
        }
        .flex_container{
            display: flex;
            flex-direction: row;
            flex-wrap: nowrap;
            
        }
        .flex_item{
            flex-grow: 1;
            
        }
    </style>
<script>
  
// page param
    

//

$(document).ready(function(){
    
    //menu설정
    $("#menu").children().hide();
    $("#menu").children().eq(0).show();

    $("#menu").mouseover(function(){
         $("#menu").children().show();
    });

    $("#menu").mouseout(function(){
        $("#menu").children().hide();
        $("#menu").children().eq(0).show();
    }); 
    
    
    $("#menu").menu({
    	
        select: function(event, ui){
        	$('.menu_panel').hide();
            switch (ui.item[0].id) {
                case "menu_1": panel01_init(); break;
                case "menu_2": panel02_init(); break;
                case "menu_3": panel03_init(); break;                    
                default:panel01_init(); break;
            }
        }
    });
    panel01_init();


    //datepicker & timesetting
    

//	var data = {title:"title1", userId:"son"};
//	transferData('/getChartList.do', data);
//	trasferData2('/getChartList.do', data);
//ibsheet P3

  	    

});

/* window.addEventListener('message', (event) => {
	  // event.origin을 통해 출처를 안전하게 검사할 수 있다.
	  console.info(event.origin);
	  if (event.origin !== 'http://localhost:8080') {
		  console.info(event.origin);
	    //return;
	  }
	  
	  // event.source 는 window.opener(팝업을 연 부모)가 된다.
	  // event.data는 부모에서 보낸 데이터인 'Hello'가 된다.
	  //event.source.postMessage('World!', event.origin); // 메시지를 받으면 메시지를 보낸 쪽에 'World!' 데이터를 보낸다.
	  console.info(event);
	  
	}, false); 

window.onload = function() {
    var message = '전달할 데이터';
    window.opener.postMessage(message, 'http://example.com:8080');
};
*/

//★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
//★★★★★★★★★★★      functions      ★★★★★★★★★★★★★★
//★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★


        function panel01_init(){
			console.info($('#panel01').css('display'));
            $('#panel01').show(); // 페이지 활성화
            console.info($('#panel01').css('display'));
            var p1_chart_index = 0; // panel01 더블클릭한 차트
            
            //p1 tab 설정
            $('#p1_tabs').tabs({
                    create: function( event, ui ) {
                    	grid01_init();
                        page01_tab01();
                    },
                    activate: function(event, ui) {
                                var index = $(ui.newTab).index();
                                
                            switch (index) {
                                case 0:
                                    page01_tab01(); 
                                break;                                                
                                case 1:
                                	//큰차트 메뉴로 이동
                                	var selectChart = window["p1_chart0" + p1_chart_index];
                                	var p1_grid_index = Math.floor(parseInt(p1_chart_index)/3);
                                	var selectGrid = window['p1_ibsheet0' + p1_grid_index]

                                	var DATE = selectGrid.ExportData({"Type":"json", "Cols":"DATE"}).data; // categories data
                                		options01.yAxis[0].tickInterval = 0.3;
                                    create_chart("p1_chart09",  setOption(options01, stringValue(DATE)), setData(lineData, selectChart.getData()[0].data), "500px");
                                     
                                break;
                                default:
                                    break;
                            }
                            }
                });
            //time setting    
            $( "#p1_fromDate" ).datepicker({dateFormat:'yy-mm-dd'});
            $( "#p1_fromDate" ).val(cal_date(-7));
            $( "#p1_toDate" ).datepicker({dateFormat:'yy-mm-dd'});
            $( "#p1_toDate" ).val(cal_date(0));
            setTime("p1_fromTime");
            setTime("p1_toTime");

            //chart dbclick시 2tabs 큰 차트로 이동
            $('.p1_chart').dblclick(function(){
                p1_chart_index = $('.p1_chart').index(this);
                $('#p1_tabs').tabs({active:1});
            });
            
            $('#p1_grid_tabs').tabs();
            

        }


        function panel02_init(){
        	//$('.menu_panel').hide();
        	console.info($('#panel02').css('display'));
        	$('#panel02').show(); // 페이지 활성화
        	console.info($('#panel02').css('display'));
             create_chart("p2_chart", options02, data02, "500px");                    
            $( "#p2_fromDate" ).datepicker({dateFormat:'yy-mm-dd'});
            $( "#p2_fromDate" ).val(cal_date(-30));
            $( "#p2_toDate" ).datepicker({dateFormat:'yy-mm-dd'});
            $( "#p2_toDate" ).val(cal_date(0));
            setTime("p2_fromTime");
            setTime("p2_toTime");

            //ibsheet P2
            var container = $("#p2_ibsheet")[0];
            createIBSheet2(container, "p2_ibsheet", "100%", "500px");
            IBS_InitSheet(p2_ibsheet, p2_initData);
            var cfg = {FrozenCol:3,MergeSheet:msHeaderOnly};
            p2_ibsheet.SetConfig(cfg);
            p2_ibsheet.SetEditable(true);
            p2_ibsheet.LoadSearchData(p2_ibsheet_data, {Sync:1}); 
            
        }
        function panel03_init(){
            $('#panel03').show(); // 페이지 활성화
            console.info('panel03_show');
            var p3_chart_index = 0;
            //p3 tab 설정
            $('#p3_tabs').tabs({
                create: function( event, ui ) {
                    page03_tab01();
                },
                activate: function(event, ui) {
                            var index = $(ui.newTab).index();
                        switch (index) {
                            case 0:
                                page03_tab01(); 
                                
                            break;                                                
                            case 1:
                                create_chart("p3_chart", options01, data01, "60vh");
                                
                            break;
                            
                            default:
                                break;
                        }
                        }

                });        

            $( "#p3_fromDate" ).datepicker({dateFormat:'yy-mm-dd'});
            $( "#p3_fromDate" ).val(cal_date(-30));
            $( "#p3_toDate" ).datepicker({dateFormat:'yy-mm-dd'});
            $( "#p3_toDate" ).val(cal_date(0));

            setTime("p3_fromTime");
            setTime("p3_toTime");
            $('.p3_chart').dblclick(function(){
                p3_chart_index = $('.p3_chart').index(this);
                $('#p3_tabs').tabs({active:1});
            });
            //ibsheet P3
            var container = $("#p3_ibsheet")[0];
            createIBSheet2(container, "p3_ibsheet", "100%", "60vh");
            IBS_InitSheet(p3_ibsheet, p2_initData);
            var cfg = {FrozenCol:3,MergeSheet:msHeaderOnly };
            p3_ibsheet.SetConfig(cfg);
            p3_ibsheet.SetEditable(true);
            p3_ibsheet.LoadSearchData(p2_ibsheet_data, {Sync:1});
        }        

                    

        //Xbar-chart

        function grid01_init(){
            var initData = {};
            createIBSheet2($("#p1_ibsheet00")[0], "p1_ibsheet00", "100%", "200px");
            initData.Cfg = {SearchMode:smLazyLoad,Page:50,MergeSheet:msHeaderOnly, AutoFitColWidth: "search|resize|init|colhidden|rowtransaction"};
            initData.HeaderMode = {Sort:1,ColMove:1,ColResize:1,HeaderCheck:0};
            initData.Cols = [
                            {Header:"",Type:"Seq",Width:50,SaveName:"SEQ",Align:"Center"},
                            {Header:"Date",Type:"Text",Width:100,SaveName:"DATE",Align:"Center"},//Format:"yyyy-MM-dd"
                            {Header:"Min",Type:"Text",Width:100,SaveName:"MIN",Align:"Center"},
                            {Header:"Max",Type:"Text",Width:100,SaveName:"MAX",Align:"Center"},
                            {Header:"R",Type:"Text",Width:100,SaveName:"R",Align:"Center"},
                            {Header:"Sample",Type:"Text",Width:100,SaveName:"SAMPLE",Align:"Center"},
                            {Header:"Avg",Type:"Text",Width:100,SaveName:"AVG",Align:"Center"},
                            {Header:"Std",Type:"Text",Width:100,SaveName:"STD",Align:"Center"},
                            {Header:"Avg-3S",Type:"Text",Width:100,SaveName:"AVG3SM",Align:"Center"},
                            {Header:"Avg+3S",Type:"Text",Width:100,SaveName:"AVG3SP",Align:"Center"},
                            {Header:"Cp",Type:"Text",Width:100,SaveName:"CP",Align:"Center"},
                            {Header:"Cpk",Type:"Text",Width:100,SaveName:"CPK",Align:"Center"},
                            ];
            				p1_ibsheet00.SetEditable(false);
                            IBS_InitSheet(p1_ibsheet00, initData);
            
            createIBSheet2($("#p1_ibsheet01")[0], "p1_ibsheet01", "100%", "200px");
            initData.Cfg = {SearchMode:smLazyLoad,Page:50,MergeSheet:msHeaderOnly, AutoFitColWidth: "search|resize|init|colhidden|rowtransaction"};
            initData.HeaderMode = {Sort:1,ColMove:1,ColResize:1,HeaderCheck:0};
            initData.Cols = [
                            {Header:"",Type:"Seq",Width:50,SaveName:"SEQ",Align:"Center"},
                            {Header:"Date",Type:"Text",Width:100,SaveName:"DATE",Align:"Center"},//Format:"yyyy-MM-dd"
                            {Header:"Min",Type:"Text",Width:100,SaveName:"MIN",Align:"Center"},
                            {Header:"Max",Type:"Text",Width:100,SaveName:"MAX",Align:"Center"},
                            {Header:"R",Type:"Text",Width:100,SaveName:"R",Align:"Center"},
                            {Header:"Sample",Type:"Text",Width:100,SaveName:"SAMPLE",Align:"Center"},
                            {Header:"Avg",Type:"Text",Width:100,SaveName:"AVG",Align:"Center"},
                            {Header:"Std",Type:"Text",Width:100,SaveName:"STD",Align:"Center"},
                            {Header:"Avg-3S",Type:"Text",Width:100,SaveName:"AVG3SM",Align:"Center"},
                            {Header:"Avg+3S",Type:"Text",Width:100,SaveName:"AVG3SP",Align:"Center"},
                            {Header:"Cp",Type:"Text",Width:100,SaveName:"CP",Align:"Center"},
                            {Header:"Cpk",Type:"Text",Width:100,SaveName:"CPK",Align:"Center"},
                            ];
            				p1_ibsheet01.SetEditable(false);
                            IBS_InitSheet(p1_ibsheet01, initData);

            createIBSheet2($("#p1_ibsheet02")[0], "p1_ibsheet02", "100%", "200px");
            initData.Cfg = {SearchMode:smLazyLoad,Page:50,MergeSheet:msHeaderOnly, AutoFitColWidth: "search|resize|init|colhidden|rowtransaction"};
            initData.HeaderMode = {Sort:1,ColMove:1,ColResize:1,HeaderCheck:0};
            initData.Cols = [
                            {Header:"",Type:"Seq",Width:50,SaveName:"SEQ",Align:"Center"},
                            {Header:"Date",Type:"Text",Width:100,SaveName:"DATE",Align:"Center"},//Format:"yyyy-MM-dd"
                            {Header:"Min",Type:"Text",Width:100,SaveName:"MIN",Align:"Center"},
                            {Header:"Max",Type:"Text",Width:100,SaveName:"MAX",Align:"Center"},
                            {Header:"R",Type:"Text",Width:100,SaveName:"R",Align:"Center"},
                            {Header:"Sample",Type:"Text",Width:100,SaveName:"SAMPLE",Align:"Center"},
                            {Header:"Avg",Type:"Text",Width:100,SaveName:"AVG",Align:"Center"},
                            {Header:"Std",Type:"Text",Width:100,SaveName:"STD",Align:"Center"},
                            {Header:"Avg-3S",Type:"Text",Width:100,SaveName:"AVG3SM",Align:"Center"},
                            {Header:"Avg+3S",Type:"Text",Width:100,SaveName:"AVG3SP",Align:"Center"},
                            {Header:"Cp",Type:"Text",Width:100,SaveName:"CP",Align:"Center"},
                            {Header:"Cpk",Type:"Text",Width:100,SaveName:"CPK",Align:"Center"},
                            ];
            				p1_ibsheet02.SetEditable(false);
                            IBS_InitSheet(p1_ibsheet02, initData);                                            
        }
        
        function page01_tab01(){
           p1_ibsheet00.DoSearch('/getChartList.do', 'fromDate=2024-10-15&toDate=2024-11-16'/* , {Sync:2} */)
           p1_ibsheet01.DoSearch('/getChartList.do', 'fromDate=2024-10-17&toDate=2024-11-16'/* , {Sync:2} */)
           p1_ibsheet02.DoSearch('/getChartList.do', 'fromDate=2024-11-05&toDate=2024-11-16'/* , {Sync:2} */)
        }
        
        function p1_ibsheet00_OnSearchEnd(code, msg){
        	
        	//categories
        	var R = p1_ibsheet00.ExportData({"Type":"json", "Cols":"R"}).data;
        	var AVG = p1_ibsheet00.ExportData({"Type":"json", "Cols":"AVG"}).data;
        	var CPK = p1_ibsheet00.ExportData({"Type":"json", "Cols":"CPK"}).data;

        	create_chart("p1_chart00", options01, setData(lineData, floatValue(AVG)), "150px");
        	create_chart("p1_chart01", options01, setData(lineData, floatValue(R)), "150px");
        	create_chart("p1_chart02", options01, setData(lineData, floatValue(CPK)), "150px");
	
    	}
        
        function p1_ibsheet01_OnSearchEnd(code, msg){
        	
        	//categories
        	var R = p1_ibsheet01.ExportData({"Type":"json", "Cols":"R"}).data;
        	var AVG = p1_ibsheet01.ExportData({"Type":"json", "Cols":"AVG"}).data;
        	var CPK = p1_ibsheet01.ExportData({"Type":"json", "Cols":"CPK"}).data;

        	create_chart("p1_chart03", options01, setData(lineData, floatValue(AVG)), "150px");
        	create_chart("p1_chart04", options01, setData(lineData, floatValue(R)), "150px");
        	create_chart("p1_chart05", options01, setData(lineData, floatValue(CPK)), "150px");
    		
    	}
        
        function p1_ibsheet02_OnSearchEnd(code, msg){
        	
        	//categories
        	var R = p1_ibsheet02.ExportData({"Type":"json", "Cols":"R"}).data;
        	var AVG = p1_ibsheet02.ExportData({"Type":"json", "Cols":"AVG"}).data;
        	var CPK = p1_ibsheet02.ExportData({"Type":"json", "Cols":"CPK"}).data;
        	
         	create_chart("p1_chart06", options01, setData(lineData, floatValue(AVG)), "150px");
        	create_chart("p1_chart07", options01, setData(lineData, floatValue(R)), "150px");
        	create_chart("p1_chart08", options01, setData(lineData, floatValue(CPK)), "150px"); 

    	}        
        
        
        function page03_tab01(){
            create_chart("p3_chart01", options02, data02, "200px");
            create_chart("p3_chart03", options02, data02, "200px");
            create_chart("p3_chart05", options02, data02, "200px");
            create_chart("p3_chart02", options03(), data3, "200px");
            create_chart("p3_chart04", options03(), data3, "200px");
            create_chart("p3_chart06", options03(), data3, "200px");
                //$("#panel_content").css({"overflow":"scroll"})
            
                //ibsheet P3_01
            var container_01 = $("#p3_ibsheet_01")[0];
            createIBSheet2(container_01, "p3_ibsheet_01", "100%", "200px");
            IBS_InitSheet(p3_ibsheet_01, initData);
            var cfg = {FrozenCol:3,MergeSheet:msHeaderOnly };
            p3_ibsheet_01.SetConfig(cfg);
            p3_ibsheet_01.SetEditable(true);
            p3_ibsheet_01.LoadSearchData(ibsheet_data, {Sync:1});
                //ibsheet P3_02
            var container_02 = $("#p3_ibsheet_02")[0];
            createIBSheet2(container_02, "p3_ibsheet_02", "100%", "200px");
            IBS_InitSheet(p3_ibsheet_02, initData);
            var cfg = {FrozenCol:3,MergeSheet:msHeaderOnly };
            p3_ibsheet_02.SetConfig(cfg);
            p3_ibsheet_02.SetEditable(true);
            p3_ibsheet_02.LoadSearchData(ibsheet_data, {Sync:1});
                //ibsheet P3_03
            var container_03 = $("#p3_ibsheet_03")[0];
            createIBSheet2(container_03, "p3_ibsheet_03", "100%", "200px");
            IBS_InitSheet(p3_ibsheet_03, initData);
            var cfg = {FrozenCol:3,MergeSheet:msHeaderOnly };
            p3_ibsheet_03.SetConfig(cfg);
            p3_ibsheet_03.SetEditable(true);
            p3_ibsheet_03.LoadSearchData(ibsheet_data, {Sync:1});
        }


       
</script>

</head>
<body>
	<form>
    <div id="header" style="height: 2em;position: fixed;top:0;left:0;width:100%;z-index: 999;background-color: #033">
    <ul id="menu">
        <li id="menu_h" class="ui-widget-header"><div>Chart</div></li>
        <li id="menu_1"><div>xBar-R[CP/CPK]</div></li>
        <li id="menu_2"><div>Scatter</div></li>
        <li id="menu_3"><div>Run & Histo</div></li>
    </ul>
    </div>

    <div id="wrapper">

        <div id="content">
		<!--panel01 st-->
        <!--panel01 st-->
        <!--panel01 st-->
        
            <div id="panel01" class="menu_panel">
                <div class="panel_head">
                    <table>
                        <colgroup>
                            <col width="10%" />
                            <col width="20%" />
                            <col width="10%" />
                            <col width="15%" />
                            <col width="10%" />
                            <col width="15%" />
                            <col width="20%" />
                        </colgroup>
                        <tr>
                            <th rowspan="2">
                                Sampling Date
                            </th>
                            <td>
                                <input id="p1_fromDate" type="text" value="" style="width:8em;"/>
                                <select id="p1_fromTime" style="width:5em;">
                                </select>
                            </td>
                            <th>
                                Plant
                            </th>
                            <td>
                                <select id="p1_search_plant" style="width:10em">
                                    <option>1공장</option>
                                    <option>2공장</option>
                                    <option>3공장</option>
                                </select>
                            </td>
                            <th>
                                Material
                            </th>
                            <td>
                                <select id="p1_search_plant" style="width:20em;">
                                    <option>B2401</option>
                                    <option>B2402</option>
                                    <option>B2403</option>
                                </select>
                            </td>                            
                        </tr>
                        <tr>
                            
                            <td>
                                <input id="p1_toDate" type="text" value="" style="width:8em;"/>
                                <select id="p1_toTime" style="width:5em;">
                                </select>
                            </td>
                            <th>
                                Sample Point
                            </th>
                            <td>
                                <select id="p1_search_samplePoint" style="width:10em;">
                                    <option>B2402</option>
                                    <option>B2403</option>
                                    <option>B2404</option>
                                </select>
                            </td>
                            <th>
                                Component
                            </th>
                            <td>
                                <select id="p1_search_component" style="width:20em;">
                                    <option>8682 : 4.CBA, 9683 : p.TA/p-TA. 8684</option>
                                    <option>8682 : 4.CBA, 9683 : p.TA/p-TA. 8684</option>
                                    <option>8682 : 4.CBA, 9683 : p.TA/p-TA. 8684</option>
                                </select>
                            </td>                        
                        </tr>
                    </table>
                </div>

                <div class="panel_content">
                   		<div id="p1_tabs">
	                        <ul>
	                          <li><a href="#p1_tabs-1" id="p1_tabs01">Graph(Multi)</a></li>
	                          <li><a href="#p1_tabs-2" id="p1_tabs02">Graph(Single)</a></li>
	                        </ul>
	                        	<div id="p1_tabs-1">
	                          
		                            <table style="width:100%;background-color: antiquewhite;">
		                                <colgroup>
		                                	 <col width="1%" />
		                                    <col width="33%" />
		                                    <col width="33%" />
		                                    <col width="33%" />
		                                </colgroup>
		                                <tr>
		                                	<td><div style="width:.9em;word-break:break-word;text-align:center">XBAR-R</div></td>
		                                    <td><div id="p1_chart00" class="p1_chart"></div></td>
		                                    <td><div id="p1_chart01" class="p1_chart"></div></td>
		                                    <td><div id="p1_chart02" class="p1_chart"></div></td>
		                                </tr>
		                                <tr>
		                               		<td><div style="width:.9em;word-break:break-word;text-align:center">P-TA/P-T</div></td>
		                                    <td><div id="p1_chart03" class="p1_chart"></div></td>
		                                    <td><div id="p1_chart04" class="p1_chart"></div></td>
		                                    <td><div id="p1_chart05" class="p1_chart"></div></td>
		                                </tr>
		                                <tr>
		                                	<td><div style="width:.9em;word-break:break-word;text-align:center">△Y/△Y</div></td>
		                                    <td><div id="p1_chart06" class="p1_chart"></div></td>
		                                    <td><div id="p1_chart07" class="p1_chart"></div></td>
		                                    <td><div id="p1_chart08" class="p1_chart"></div></td>
		                                </tr>
		                            </table>
	                         	</div>
		                        <div id="p1_tabs-2">
		                            <div id="p1_chart09"></div>
		                        </div>

                    	</div>
                    
                    <!-- ibsheet 그리드 -->
                    <div id="p1_grid_tabs">
	                      <ul>
	                        <li><a href="#p1_grid_tab01" id="p1_grid_tab01_head">XBAR-R</a></li>
	                        <li><a href="#p1_grid_tab02" id="p1_grid_tab02_head">P-TA/P-T</a></li>
	                        <li><a href="#p1_grid_tab03" id="p1_grid_tab03_head">△Y/△Y</a></li>
	                      </ul>
	                      <div id="p1_grid_tab01">
			                    <div>
			                        <div id='p1_ibsheet00'></div>
			                    </div>
			              </div>
	                      <div id="p1_grid_tab02">
			                    <div>
			                        <div id='p1_ibsheet01'></div>
			                    </div>
			              </div>
	                      <div id="p1_grid_tab03">
			                    <div>
			                        <div id='p1_ibsheet02'></div>
			                    </div>
			              </div>
                	</div>    
                
            	</div>
            <!--panel_content -->
            </div>
        <!--panel01 fn-->
        <!--panel01 fn-->
        <!--panel01 fn-->

        <!--panel02 st-->
        <!--panel02 st-->            
        <!--panel02 st-->
            <div id="panel02" class="menu_panel">
                <div class="panel_head">
                    <table style="width: 100%;background-color: #eee;padding:.5em">
                        <colgroup>
                            <col width="10%" />
                            <col width="15%" />
                            <col width="10%" />
                            <col width="15%" />
                            <col width="10%" />
                            <col width="15%" />
                            <col width="25%" />
                        </colgroup>
                        <tr>
                            <th>
                                Sampling Date
                            </th>
                            <td colspan="2">
                                <div class="flex_container">
                                    <div class="flex_item">
                                        <input id="p2_fromDate"  type="text" value="" style="width:8em;"/>
                                        <select id="p2_fromTime" style="width:5em;">
                                        </select>
                                    </div>
                                    <div class="flex_item" style="margin-left:1em">
                                        <input id="p2_toDate" type="text" value="" style="width:8em;"/>
                                        <select id="p2_toTime" style="width:5em;">
                                        </select>
                                    </div>
                                
                                </div>
                            </td>
                            <th>
                                Plant
                            </th>
                            <td>
                                <select id="p2_search_plant" style="width:10em">
                                    <option>1공장</option>
                                    <option>2공장</option>
                                    <option>3공장</option>
                                </select>
                            </td>   
                            <td></td>
                            <td></td>
                            <td></td>
                                           
                        </tr>
                        <tr>
                            <th>
                                X:Material
                            </th>
                            <td>
                                <select id="p2_x_material" style="width:10em;">
                                    <option>B2402</option>
                                    <option>B2403</option>
                                    <option>B2404</option>
                                </select>
                            </td>
                            <th>
                                Sample Point
                            </th>
                            <td>
                                <select id="p2_search_samplePoint" style="width:10em;">
                                    <option>B2402</option>
                                    <option>B2403</option>
                                    <option>B2404</option>
                                </select>
                            </td>
                            <th>
                                Component
                            </th>
                            <td>
                                <select id="p2_search_component" style="width:20em;">
                                    <option>8682 : 4.CBA, 9683 : p.TA/p-TA. 8684</option>
                                    <option>8682 : 4.CBA, 9683 : p.TA/p-TA. 8684</option>
                                    <option>8682 : 4.CBA, 9683 : p.TA/p-TA. 8684</option>
                                </select>
                            </td>
                                                       
                        </tr>
                        <tr>
                            <th>
                                Y:Material
                            </th>
                            <td>
                                <select id="p2_y_material" style="width:10em;">
                                    <option>B2402</option>
                                    <option>B2403</option>
                                    <option>B2404</option>
                                </select>
                            </td>
                            <th>
                                Sample Point
                            </th>
                            <td>
                                <select id="p2_search_samplePoint" style="width:10em;">
                                    <option>B2402</option>
                                    <option>B2403</option>
                                    <option>B2404</option>
                                </select>
                            </td>
                            <th>
                                Component
                            </th>
                            <td>
                                <select id="p2_search_component" style="width:20em;">
                                    <option>8682 : 4.CBA, 9683 : p.TA/p-TA. 8684</option>
                                    <option>8682 : 4.CBA, 9683 : p.TA/p-TA. 8684</option>
                                    <option>8682 : 4.CBA, 9683 : p.TA/p-TA. 8684</option>
                                </select>
                            </td>
                            
                        </tr>
                    </table>
                </div>
                <table style="width:100%">
	                <tr>
		                <td style="width:70%">
		                	<div id="p2_chart"></div>
		                </td>
		                <td style="width:30%">
		                	<div id="p2_ibsheet"></div>
		                </td>
	                </tr>
                </table>
                
                
                <table>
	                <tr>
		                <td>
			                <div>Correlation</div>
			                <div class="flex_container" style="border:1px solid #ccc;border-radius: .3em;padding:.5em 1em">
				                <div>
				                	<div>Correliance(X,Y):</div> 
				                	<input type="text" id="p2_correl01" name="p2_correl01" value="0.688"/>
								</div>
								<div style="margin-left:1em">
				                	<div>Correlation Coefficient:</div>
				                	<input type="text" id="p2_correl02" name="p2_correl02" value="0.051"/>
			                	</div> 
			                </div>
			                
		                </td>
						<td>
							
							<div>Regression</div>
			                <div class="flex_container" style="border:1px solid #ccc;border-radius: .3em;padding:.5em 1em">
				                <div>
				                	<div>Regression Coefficient:</div> 
				                	<input type="text" id="p2_reg01" name="p2_reg01" value="0.73"/>
								</div>
								<div style="margin-left:1em">
				                	<div>Regression Equation:</div>
				                	<input type="text" id="p2_reg02" name="p2_reg02" value="Y=0.73X + 11898"/>
			                	</div> 
			                </div>
			               
		                </td>
		                <td>
		                	<div>Data</div>
			                <div class="flex_container" style="border:1px solid #ccc;border-radius: .3em;padding:.5em 1em">
				                <div>
				                	<div>Data Num:</div> 
				                	<input type="text" id="p2_data01" name="p2_data01" value="39"/>
								</div> 
			                </div>
		                </td>
	                </tr>
                </table>

            </div>
        <!--panel02 fn-->
        <!--panel02 fn-->
        <!--panel02 fn-->                



        <!--panel03 st-->
        <!--panel03 st-->
        <!--panel03 st-->
            <div id="panel03" class="menu_panel" style="background-color:#ccc">

                <div class="panel_head">
                    <table style="width: 100%;background-color: #eee;padding:.5em">
                        <colgroup>
                            <col width="10%" />
                            <col width="20%" />
                            <col width="10%" />
                            <col width="15%" />
                            <col width="10%" />
                            <col width="15%" />
                            <col width="20%" />
                        </colgroup>
                        <tr>
                            <th rowspan="2">
                                Sampling Date
                            </th>
                            <td>
                                <input id="p3_fromDate" name="p3_fromDate" type="text" value="" style="width:8em;"/>
                                <select id="p3_fromTime" name="p3_fromTime" style="width:5em;">
                                </select>
                            </td>
                            <th>
                                Plant
                            </th>
                            <td>
                                <select id="p3_search_plant" style="width:10em">
                                    <option>1공장</option>
                                    <option>2공장</option>
                                    <option>3공장</option>
                                </select>
                            </td>
                            <th>
                                Material
                            </th>
                            <td>
                                <select id="p3_search_plant" style="width:20em;">
                                    <option>B2401</option>
                                    <option>B2402</option>
                                    <option>B2403</option>
                                </select>
                            </td>     
                                                  
                        </tr>
                        <tr>
                            
                            <td>
                                <input id="p3_toDate" type="text" value="" style="width:8em;"/>
                                <select id="p3_toTime" style="width:5em;">
                                </select>
                            </td>
                            <th>
                                Sample Point
                            </th>
                            <td>
                                <select id="p3_search_samplePoint" style="width:10em;">
                                    <option>B2402</option>
                                    <option>B2403</option>
                                    <option>B2404</option>
                                </select>
                            </td>
                            <th>
                                Component
                            </th>
                            <td>
                                <select id="p3_search_component" style="width:20em;">
                                    <option>8682 : 4.CBA, 9683 : p.TA/p-TA. 8684</option>
                                    <option>8682 : 4.CBA, 9683 : p.TA/p-TA. 8684</option>
                                    <option>8682 : 4.CBA, 9683 : p.TA/p-TA. 8684</option>
                                </select>
                            </td>                            
                            <td></td>
                            <td></td>
                            
                        </tr>
                    </table>
                </div>
                
               <div class="panel_content">
                    <div id="p3_tabs">
                        <ul>
                          <li><a href="#p3_tabs-1" id="p3_tabs01">Graph(Multi)</a></li>
                          <li><a href="#p3_tabs-2" id="p3_tabs02">Graph(Single)</a></li>
                        </ul>
                        <div id="p3_tabs-1">
                          
                            <table style="width:100%;background-color: antiquewhite;">
                                <colgroup>
                                    <col width="33%" />
                                    <col width="33%" />
                                    <col width="33%" />
                                </colgroup>
                                <tr>
                                    <td><div id="p3_chart01" class="p3_chart"></div></td>
                                    <td><div id="p3_chart02" class="p3_chart"></div></td>
                                    <td><div id="p3_ibsheet_01"></div></td>
                                </tr>
                                <tr>
                                    <td><div id="p3_chart03" class="p3_chart"></div></td>
                                    <td><div id="p3_chart04" class="p3_chart"></div></td>
                                    <td><div id="p3_ibsheet_02"></div></td>
                                </tr>
                                <tr>
                                    <td><div id="p3_chart05" class="p3_chart"></div></td>
                                    <td><div id="p3_chart06" class="p3_chart"></div></td>
                                    <td><div id="p3_ibsheet_03"></div></td>
                                </tr>
                            </table>
                        </div>
                        <div id="p3_tabs-2">
                            <table style="width:100%">
                                <tr>
                                    <td style="width:70%">
                                        <div id="p3_chart"></div>
                                    </td>
                                    <td style="width:30%">
                                        <div id="p3_ibsheet"></div>
                                    </td>
                                </tr>
                            </table>
                        </div>

                    </div>
                    
                    <!-- ibsheet 그리드 -->
                    <div>
                        <div id='p3_ibsheet'></div>
                    </div>
                   
                </div>    
                <!--panel_content -->

            </div>
        <!--panel03 fn-->
        <!--panel03 fn-->
        <!--panel03 fn-->
        </div>
    </div>

    <!-- <div style="height: 3em;position: fixed;bottom:0;width:100%"> bottom </div> -->
<!-- <div style='height:calc(100% - 20px)'><div id="chart0" style="width:100%;height:100%;"></div></div> -->

 </form>
</body>
</html>