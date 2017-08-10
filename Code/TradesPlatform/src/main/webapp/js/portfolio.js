$(document).ready(function() {
    // 发起Ajax请求
	getTraderPortfolio();
});

function getTraderPortfolio() {
	// 检查Trader是否登陆了
	var traderId = sessionStorage.getItem("traderId");
	if (traderId == null) {
		location.href = "/TradesPlatform/newLogin.jsp";
		return;
	} else {
		console.log("Trader Logined");
	}
	
	var json = {
		"traderId": traderId,
	};
	
	$.ajax({
		data : JSON.stringify(json),
		contentType : "text/html;charset=utf-8",
		type : "POST",
		dataType : "json",
		url : "traderPortfolio.spring",
		error : function(data) {
			// console.error("error:" + JSON.stringify(data));
			alert("Server Error!");
		},
		success : function(map) {
			initTable(map);
		}
	});
}

function initTable(data) {
	var dom = document.getElementById("container");
	var myChart = echarts.init(dom);
	var app = {};
	option = null;
	option = {
		tooltip : {
			trigger: 'item',
			formatter: "{a} <br/>{b} : {c} ({d}%)"
		},
		legend: {
			orient: 'vertical-align',
			right: '50',
			top:'30',
			data: getSymbols(data),
		},
		series : [
			{
				type: 'pie',
				radius : [0, '70%'],
				center: ['50%', '50%'],
				data: getDataArray(data),
				itemStyle: {
					emphasis: {
						shadowBlur: 10,
						shadowOffsetX: 0,
						shadowColor: 'rgba(0, 0, 0, 0.5)'
					}
				}
			}
		]
	};
	
	
	option2 = {
		    title : {
		        text: 'Portfolio Display',
		        x:'center'
		    },
		    tooltip : {
		        trigger: 'item',
		        formatter: "{a} <br/>{b} : {c} ({d}%)"
		    },
		    legend: {
		    		x : 'center',
		        y : 'bottom',
		        data:getSymbols(data),
		    },
		    toolbox: {
		        show : false,
		        feature : {
		            mark : {show: true},
		            dataView : {show: true, readOnly: false},
		            magicType : {
		                show: true, 
		                type: ['pie', 'funnel']
		            },
		            restore : {show: true},
		            saveAsImage : {show: true}
		        }
		    },
		    calculable : true,
		    series : [
		        {
		            name:'Portfolio Display',
		            type:'pie',
		            radius : [0, '60%'],
		            center : ['50%', '50%'],
		            roseType : 'area',
		            x: '50%',               // for funnel
		            max: 40,                // for funnel
		            sort : 'ascending',     // for funnel
		            textStyle: {
		                color: '#ccc'
		            },
		            data:getDataArray(data),
		            roseType: 'radius',
		            label: {
		                normal: {
		                    textStyle: {
		                        color: 'rgba(0, 0, 0, 0.7)'
		                    }
		                }
		            },
		            labelLine: {
		                normal: {
		                    lineStyle: {
		                        color: 'rgba(0, 0, 0, 0.7)'
		                    },
		                    smooth: 0.2,
		                    length: 10,
		                    length2: 20
		                }
		            },
		            animationType: 'scale',
		            animationEasing: 'elasticOut',
		            animationDelay: function (idx) {
		                return Math.random() * 200;
		            },
		        }
		    ]
		};
		                    
	
	if (option2 && typeof option2 === "object") {
		myChart.setOption(option2, true);
	}
}

function getDataArray(data) {
	var arr = new Array()
	for(var key in data){
		var item = {
			"value": data[key].principle,
			"name": key,
		};
		arr.push(item);
	}
	console.log(arr);
	return arr;
}

function getSymbols(data) {
	var symbols = new Array()
	for(var key in data){
		symbols.push(key);
	}
	console.log(symbols);
	return symbols;
}

