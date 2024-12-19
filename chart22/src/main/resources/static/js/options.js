	function setOption(data, value){
		var temp = $.extend(true, {}, data);
		temp.xAxis[0].categories = value;
		delete temp.xAxis[0].labels;
		return temp; 
	};
//XBAR-R
var options01 = {
    "colors": [
      "#4682B4"
    ],
    "chart": {
      "type": "line"
    },
    /*"subtitle": {
      "text": "XBAR-R",
      "align": "Center",
      "style": {
        "color": "#242424"
      }
    },*/
    "xAxis": {
		
	  "labels":"",
      /*"categories": 
	  [
        "2024-01-01",
        "2024-01-02",
        "2024-01-03",
        "2024-01-04",
        "2024-01-05",
        "2024-01-06",
        "2024-01-07",
        "2024-01-08",
        "2024-01-09",
        "2024-01-10",
        "2024-01-11",
        "2024-01-12",
        "2024-01-13",
        "2024-01-14",
        "2024-01-15"
      ],*/
      "gridLineWidth": 1
    },
    "yAxis": {
      "title": {
        "text": "",
        "align": "low",
		
        "rotation": 0,
        "style": {
          "color": "#575757",
          "fontSize": "10px"
        }
      },
	  "tickInterval" : 0.5,
      "showFirstLabel": false
    },
    "plotOptions": {
      "series": {
        "dataLabels": {
          "enabled": false
        },
        "shadow": false
      }
    },
    "legend": {
		"enabled":false
     
    },
    "tooltip": {
      "valueSuffix": ""
    }
  };
  
  
  
  
  var options02 = {   
          "colors": [
              "#005766"
              
          ],
          "chart": {
              "type": "scatter",
              "zoomType": "xy"
          },
          "yAxis": {
              "title": {
              "text": ""
              }
          },
          "legend": {
              "enabled": false,
              "align": "right",
              "verticalAlign": "top",
              "layout": "vertical"
          }
  }
  
  

function options03(){
 
    var options = {
                    "chart": {
                        "type": ["spline", "bar"],
                    },
                    "colors": ["#2ea4a8"],
                    "xAxis": {
                        "categories": data03.data00,
                        "crosshair": true,
                        "lineWidth": 1,
                        
                    },

                    "yAxis": [
                        
                        {
                        
                        "labels": {
                            "format": "{value}"
                        },
                        "title": {
                            "text": ""
                        }
                        },
                        {
                            
                        "title": {
                            "text": ""
                        },
                        "labels": {
                            "format": "{value}"
                        },
                        "opposite": true
                        },
                     
    
                    ],
                    "tooltip": {
                        "headerFormat": "",
                        "shared": true
                    }
                    };
            return options;
}
       

//ibsheet 

var initData = {
    "Cfg": {
        "SearchMode": 2,
        "Page": 10,
        "FrozenCol": 0,
        "UseHeaderActionMenu": false,
        "MouseHoverMode": 1,
        "SelectionRowsMode": 1,
        "AutoFitColWidth": "search|resize|init|colhidden|rowtransaction",
        "DeferredVScroll": 1
    },
    "HeaderMode": {
      
        
    },
    "Cols": [{
        "Header": "",
        "Type": "Seq",
        "Width": 50,
        "SaveName": "SEQ",
        "Align": "Center"
    }, {
        "Header": "Date",
        "Type": "Text",
        "Width": 100,
        "SaveName": "DATE",
        "Align": "Center",
    }, {
      "Header": "Min",
      "Type": "Text",
      "Width": 100,
      "SaveName": "MIN",
      "Align": "Center",
    }, {
      "Header": "Max",
      "Type": "Text",
      "Width": 100,
      "SaveName": "MAX",
      "Align": "Center",
    }, {
      "Header": "R",
      "Type": "Text",
      "Width": 100,
      "SaveName": "R",
      "Align": "Center",
    }, {
      "Header": "Sample",
      "Type": "Text",
      "Width": 100,
      "SaveName": "SAMPLE",
      "Align": "Center",
    }, {
      "Header": "Avg",
      "Type": "Text",
      "Width": 100,
      "SaveName": "AVG",
      "Align": "Center",
    }, {
      "Header": "Std",
      "Type": "Text",
      "Width": 100,
      "SaveName": "STD",
      "Align": "Center",
    }, {
      "Header": "Avg-3S",
      "Type": "Text",
      "Width": 100,
      "SaveName": "AVG3SM",
      "Align": "Center",
    }, {
      "Header": "Avg+3S",
      "Type": "Text",
      "Width": 100,
      "SaveName": "AVG3SP",
      "Align": "Center",
    }, {
      "Header": "Cp",
      "Type": "Text",
      "Width": 100,
      "SaveName": "CP",
      "Align": "Center",
    }, {
      "Header": "Cpk",
      "Type": "Text",
      "Width": 100,
      "SaveName": "CPK",
      "Align": "Center",
    }   ]
};                


var p2_initData = {
  "Cfg": {
      "SearchMode": 2,
      "Page": 10,
      "FrozenCol": 0,
      "UseHeaderActionMenu": false,
      "MouseHoverMode": 1,
      "SelectionRowsMode": 1,
      "AutoFitColWidth": "search|resize|init|colhidden|rowtransaction",
      "DeferredVScroll": 1
  },
  "HeaderMode": {
    
      
  },
  "Cols": [{
      "Header": "",
      "Type": "Seq",
      "Width": 50,
      "SaveName": "SEQ",
      "Align": "Center"
  }, {
      "Header": "Date",
      "Type": "Text",
      "Width": 100,
      "SaveName": "DATE",
      "Align": "Center",
  }, {
    "Header": "4-CBA/4-CBA",
    "Type": "Text",
    "Width": 100,
    "SaveName": "R1",
    "Align": "Center",
  }, {
    "Header": "p-TA/p-TA",
    "Type": "Text",
    "Width": 100,
    "SaveName": "R2",
    "Align": "Center",
  } ]
};            
