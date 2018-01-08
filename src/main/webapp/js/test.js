function add() {
	var shop = {
		"shopname" : $('#shopname').val(),
		"goodstype" : $('#goodstype').val(),
		"us" : $('#us').val(),
		"pw" : $('#pw').val(),
		"ShopOnlyID" : $('#ShopOnlyID').val(),
		"shopms" : $('#shopms').val(),
		"shitidian" : $('#shitidian').val(),
		"ShopAddress" : $('#ShopAddress').val(),
		"state" : $('#state').val(),
		"advertisingurl" : $('#advertisingurl').val(),
		"ZTState" : $('#ZTState').val(),
		"addtime" : $('#addtime').val(),
		"OpeningDate" : $('#OpeningDate').val(),
		"AboutFullDate" : $('#AboutFullDate').val(),
		"theorder" : $('#theorder').val(),
		"shopMan" : $('#shopMan').val(),
		"Tel" : $('#Tel').val(),
		"ShopWhatsapp" : $('#ShopWhatsapp').val(),
		"ShopWechat" : $('#ShopWechat').val(),
		"ShoPCID" : $('#ShoPCID').val()
	};
	var data={"shop":shop};
	console.log(data);
	$.ajax({
		url : "shopController/shopAdd.easy",
		contentType: 'application/json',  
		data :shop,
		type : "post",
		dataType : "JSON",
		success : function(data) {
			console.log(data);
		},
	});
}