$(document).ready(function() {
    var dom = document.getElementById("container");
	var myChart = echarts.init(dom);
	var app = {};
	option = null;
	option = {
	 /*   title : {
			text: 'portflio',
			subtext: 'trader',
			x:'center'
		},*/
		tooltip : {
			trigger: 'item',
			formatter: "{a} <br/>{b} : {c} ({d}%)"
		},
		legend: {
			orient: 'vertical-align',
			right: '50',
			top:'30',
			data: ['aaa','bbb','ccc','ddd','eee']
		},
		series : [
			{
			//    name: 'portflio',
				type: 'pie',
				radius : '65%',
				center: ['70%', '60%'],
				data:[
					{value:800, name:'aaa'},
					{value:310, name:'bbb'},
					{value:234, name:'ccc'},
					{value:135, name:'ddd'},
					{value:1548, name:'eee'}
				],
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
		        subtext: 'Portfolio Display',
		        x:'center'
		    },
		    tooltip : {
		        trigger: 'item',
		        formatter: "{a} <br/>{b} : {c} ({d}%)"
		    },
		    legend: {
		        x : 'center',
		        y : 'bottom',
		        data:['rose1','rose2','rose3','rose4','rose5','rose6','rose7','rose8']
		    },
		    toolbox: {
		        show : true,
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
		            radius : [30, 110],
		            center : ['50%', 150],
		            roseType : 'area',
		            x: '50%',               // for funnel
		            max: 40,                // for funnel
		            sort : 'ascending',     // for funnel
		            data:[
		                {value:10, name:'rose1'},
		                {value:5, name:'rose2'},
		                {value:15, name:'rose3'},
		                {value:25, name:'rose4'},
		                {value:20, name:'rose5'},
		                {value:35, name:'rose6'},
		                {value:30, name:'rose7'},
		                {value:40, name:'rose8'}
		            ]
		        }
		    ]
		};
		                    
	
	if (option2 && typeof option2 === "object") {
		myChart.setOption(option2, true);
	}
});

