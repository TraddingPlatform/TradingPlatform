$(function() {

	// 检查Trader是否登陆了
	var traderId = sessionStorage.getItem("traderId");
	if (traderId != null) {

	} else {
		// alert("Trader not logined");
		location.href = "/TradesPlatform/newLogin.jsp";
	}

	// 1.初始化Table
	var oTable = new TableInit();
	oTable.Init();

	// 2.初始化Button的点击事件
	var oButtonInit = new ButtonInit();
	oButtonInit.Init();
});

function search() {
	$('#tb_departments').bootstrapTable('refresh');
}

var TableInit = function() {
	var oTableInit = new Object();
	// 初始化Table
	oTableInit.Init = function() {
		$('#tb_departments').bootstrapTable({
			url : '/TradesPlatform/traderOrderBook.spring', // 请求后台的URL（*）
			method : 'post', // 请求方式（*）
			toolbar : '#toolbar', // 工具按钮用哪个容器
			striped : true, // 是否显示行间隔色
			cache : false, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination : true, // 是否显示分页（*）
			sortable : false, // 是否启用排序
			sortOrder : "asc", // 排序方式
			queryParams : oTableInit.queryParams,// 传递参数（*）
			sidePagination : "server", // 分页方式：client客户端分页，server服务端分页（*）
			pageNumber : 1, // 初始化加载第一页，默认第一页
			pageSize : 10, // 每页的记录行数（*）
			pageList : [ 10], // 可供选择的每页的行数（*）
			search : false, // 是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			strictSearch : true,
			showColumns : false, // 是否显示所有的列
			showRefresh : false, // 是否显示刷新按钮
			minimumCountColumns : 2, // 最少允许的列数
			clickToSelect : true, // 是否启用点击选中行
			height : 500, // 行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
			uniqueId : "id", // 每一行的唯一标识，一般为主键列
			showToggle : false, // 是否显示详细视图和列表视图的切换按钮
			cardView : false, // 是否显示详细视图
			detailView : false, // 是否显示父子表
			columns : [ {
				checkbox : true
			}, {
				field : 'id',
				title : 'ID'
			}, {
				field : 'traderId',
				title : 'Trader ID'
			}, {
				field : 'price',
				title : 'Price'
			}, {
				field : 'equitySymbol',
				title : 'Symbol'
			}, {
				field : 'isBuy',
				title : 'Buy / Sale'
			}, {
				field : 'quantity',
				title : 'Quantity'
			}, ]
		});
	};

	// 得到查询的参数
	oTableInit.queryParams = function(params) {
		var traderId = sessionStorage.getItem("traderId");
		var temp = { // 这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
			limit : params.limit, // 页面大小
			offset : params.offset, // 页码
			traderId : traderId, // Trader ID
			symbol : $("#txt_search_symbol").val(), // 搜索Symbol
		};
		var json = JSON.stringify(temp);
		console.log(json);
		return temp;
	};
	return oTableInit;
};

var ButtonInit = function() {
	var oInit = new Object();
	var postdata = {};

	oInit.Init = function() {
		// 初始化页面上面的按钮事件
		// 编辑数据click事件注册
		$("#btn_edit").click(
				function() {
					var arrselections = $("#tb_departments").bootstrapTable(
							'getSelections');
					if (arrselections.length > 1) {
						alert("Can only select one line to edit.");
						return;
					}
					if (arrselections.length <= 0) {
						alert("Please select valid data.");
						return;
					}
					$("#myModalLabel").text("Edit");
					$("#txt_price").val(arrselections[0].price);
					$("#txt_quantity").val(arrselections[0].quantity);

					postdata.ROLE_ID = arrselections[0].ROLE_ID;
					$('#myModal').modal();
				});

		$("#btn_submit").click(
				function() {
					var arrselections = $("#tb_departments").bootstrapTable(
							'getSelections');
					var requestData = {
						"orderBookId" : arrselections[0].id,
						"traderId" : arrselections[0].traderId,
						"price" : $("#txt_price").val(),
						"equitySymbol" : arrselections[0].equitySymbol,
						"isBuy" : arrselections[0].isBuy,
						"quantity" : $("#txt_quantity").val(),
					};
					$.ajax({
						type : "post",
						contentType : "text/html;charset=utf-8",
						url : "/TradesPlatform/tradeModify.spring",
						data : JSON.stringify(requestData),
						dataType : "json",
						success : function(data) {
							if (data.result == true) {
								alert("Update success");
								$('#tb_departments').bootstrapTable('refresh');
							} else {
								alert("Update fail.");
							}
						},
						error : function() {
							toastr.error('Error');
						},
						complete : function() {

						}

					});
				});
		
		$("#btn_delete").click(
				function() {
					var arrselections = $("#tb_departments")
							.bootstrapTable('getSelections');
					if (arrselections.length > 1) {
						alert("Can only select one line to edit.");
						return;
					}
					if (arrselections.length <= 0) {
						alert("Please select valid data.");
						return;
					}
					
					var requestData = {
						"orderBookId": arrselections[0].id,
					};
					
					$.ajax({
						type : "post",
						contentType : "text/html;charset=utf-8",
						url : "/TradesPlatform/tradeCancle.spring",
						data : JSON.stringify(requestData),
						dataType : "json",
						success : function(data) {
							if (data.result == true) {
								alert("Cancle success");
								$('#tb_departments').bootstrapTable('refresh');
							} else {
								alert("Cancle fail.");
							}
						},
						error : function() {
							toastr.error('Error');
						},
						complete : function() {
						}

					});
					
				});
	};

	return oInit;
};
