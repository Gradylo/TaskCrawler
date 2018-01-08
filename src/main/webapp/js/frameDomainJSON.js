///**
// * 
// * frameDomainJSOn.js需要jquery 支持
// */
var domain = ".macaoeasybuy.com";
//
// /**
// * 服務器路徑 商城
// */
// addModel_server("www", _mall_module_server_size, _mall_module, domain);
// /**
// * 服務器路徑 社交
// */
// addModel_server("social", _social_module_server_size, _social_module,
// domain);
//
// /**
// * 服務器路徑 用戶空間
// */
// addModel_server("userSpace", _userSpace_module_server_size,
// _userSpace_module,
// domain);
// /**
// * 服務器路徑 用戶登錄管理
// */
// addModel_server("userManager", _userManager_module_server_size,
// _userManager_module, domain);
//
// function localDoucment(str, modul, dom) {
// modul.push(str + dom);
// }
// function addModel_server(str, size, modul, dom) {
// for ( var i = 0; i < size; i++) {
// var str2 = str;
// if (i != 0) {
// str2 = str2 + i;
// }
// localDoucment(str2, modul, dom);
// }
// }
// if (typeof jQuery == 'undefined') {
//
// } else {
// // jQuery 已加载
// }
//
// function frameDomainJSON(url, pram) {
//
// $.getJSON(url, pram, function(data) {
//
// }, "JSON");
//
// }
$(function() {
	// Isverify();
	generateverify();
	prefixUrl();
});
function Isverify() {
	var parmData = getUrlParam("_encryption");
	var parmData_ = getUrlParam("_term");
	var loadUrl = window.location.host + window.location.port;
	if (parmData == "null" || parmData == null || parmData == ""
			|| parmData_ == "null" || parmData_ == null || parmData_ == "") {
		window.location.href = loadUrl;
	} else {
		var times = getNowFormatDate() - parmData_;
		if (times > 3000000 || times < 0) {
			alert("頁面丟失");
			window.location.href = loadUrl;
		}
		var los = location.href;
		los = los.replace("&_encryption=" + parmData, "");
		los = los.replace("?_encryption=" + parmData, "");
		los = los.replace("&_term=" + parmData_, "");
		// console.log(parmData + "\n \n " + systemAci(los) + ":" + los);
		// los = replaceAtre(los);
		// console.log(decodeURI(los));
		if (parmData != systemAci(decodeURI(los))) {
			window.location.href = loadUrl;
		}
	}
}

function generateverify() {
	var dataUrlA = $("a");
	for ( var i = 0; i < dataUrlA.length; i++) {
		var easys = dataUrlA[i];
		var Tx = $(easys).attr("data-easybuy");
		if (Tx == "?") {
			var href = $(easys).attr("href");
			$(easys).attr("href", addUrlParamesIs(href));
		}
	}
	$("a").click(function() {
		var dataeasybuy = $(this);
		for ( var i = 0; i < dataeasybuy.length; i++) {
			var easys = dataeasybuy[i];
			var Tx = $(easys).attr("data-easybuy");
			if (Tx == "?") {
				var href = $(easys).attr("href");
				$(easys).attr("href", addUrlTimeIs(href));
			}
		}
	});
}

function addHref(href) {
	var param = addUrlParamesIs(href);
	var time = addUrlTimeIs(href);
	return href + param + time;
}

function addUrlTimeIs(href) {
	var param = "&_term=" + getNowFormatDate();
	return  param;
}

function addUrlParamesIs(href) {
	var hrefToken = systemAci(href);
	var param = "?_encryption=" + hrefToken;
	if (href.indexOf("?") >= 0) {
		param = "&_encryption=" + hrefToken;
	}
	return  param;
}
// 加密
function systemAci(str) {
	// str = encodeUTF8(str);
	// console.log(str);
	// str = replaceAtre(str);
	// console.log(str);
	str = replaceAtre(str);
	str = str.toLowerCase();
	console.log(str);
	var strs = "";
	for ( var i = 0; i < str.length; i++) {
		// 每一個字符
		var ins = str[i];
		if (!isNaN(ins)) {
			if (ins == 0)
				ins = "a";
			if (ins == 1)
				ins = "b";
			if (ins == 2)
				ins = "c";
			if (ins == 3)
				ins = "d";
			if (ins == 4)
				ins = "e";
			if (ins == 5)
				ins = "f";
			if (ins == 6)
				ins = "g";
			if (ins == 7)
				ins = "h";
			if (ins == 8)
				ins = "i";
			if (ins == 9)
				ins = "j";
			// console.log(ins);
		}
		var int = ins.charCodeAt(ins);
		// console.log(ins + ":" + ins.charCodeAt(ins));
		strs += (i + int);
	}
	return strs;
}
function replaceAtre(str) {
	// str = str.replace("\/\/", "");
	// str = str.replace("\/", "");
	// str = str.replace("\/", "");
	// str = str.replace("?", "");
	// str = str.replace(/=/g, "");
	// str = str.replace(/&/g, "");
	// str = str.replace(/:/g, "");
	// str = str.replace(".", "");
	str = str.replace(/ /g, "");
	str = str.replace("?", "");
	str = str.replace(/&/g, "");
	str = str.replace("easybuyCallback=?", "");
	// str = str.replace(/^[0-9]*$/g, "");
	return str;
}
function getNowFormatDate() {
	var eay = onreadystatechange();
	var currentDateLong = new Date(eay.replace(new RegExp("-", "gm"), "/"))
			.getTime();
	return currentDateLong;
}
function onreadystatechange() {
	var time = null, curDate = null;
	var enss = null;
	// var d = new Date('<%=DateTime.Now.ToString("yyyy\\/MM\\/dd
	// HH:mm:ss")%>');
	$.ajax({
		type : "OPTIONS",
		async : false,
		url : "/",
		complete : function(x) {
			time = x.getResponseHeader("Date");
			// console.log(xhr.getAllResponseHeaders());
			curDate = new Date(time);
			enss = curDate.getFullYear() + "-" + (curDate.getMonth() + 1) + "-"
					+ curDate.getDate() + " " + curDate.getHours() + ":"
					+ curDate.getMinutes() + ":" + curDate.getSeconds();
		}
	});
	return enss;
}
function getUrlParam(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if (r != null)
		return unescape(r[2]);
	return null;
}
function getCookie(name) {
	var arr, reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");
	if (arr = document.cookie.match(reg))
		return unescape(arr[2]);
	else
		return null;
}
function setCookie(name, value, time) {
	var strsec = getsec(time);
	var exp = new Date();
	exp.setTime(exp.getTime() + strsec * 1);
	document.cookie = name + "=" + escape(value) + ";expires="
			+ exp.toGMTString();
}
var icyPass_ = 23451;
// /**
// *
// * @param str
// * 單個參數值
// */
function parameIcy5c(str) {
	var _in = "";
	str = str.toLowerCase();
	var su = 1;
	for ( var i = 0; i < str.length; i++) {
		var ins = str[i];
		if (!isNaN(ins) && $.trim(ins) != "") {
			if (ins == 0)
				ins = "∝";
			if (ins == 1)
				ins = "∽";
			if (ins == 2)
				ins = "∈";
			if (ins == 3)
				ins = "∞";
			if (ins == 4)
				ins = "≌";
			if (ins == 5)
				ins = "∉";
			if (ins == 6)
				ins = "∥";
			if (ins == 7)
				ins = "∬";
			if (ins == 8)
				ins = "∭";
			if (ins == 9)
				ins = "∂";
			// console.log(ins);
		}
		if (su == 10000) {
			su = 1;
		}
		var os = (ins.charCodeAt(ins) + su) + "";
		su++;
		if (os.length == 1) {
			os = "00000" + os;
		} else if (os.length == 2) {
			os = "0000" + os;
		} else if (os.length == 3) {
			os = "000" + os;
		} else if (os.length == 4) {
			os = "00" + os;
		} else if (os.length == 5) {
			os = "0" + os;
		}
		_in += os;
	}
	return _in;
}
function getUserInfo() {
	var _info = getCookie("ENYSTRINETI_STRING");
	if (_info == "") {
		return "";
	}
	var datas = "";
	$.ajaxSettings.async = false;
	var url = "http://userManager.macaoeasybuy.com/UserInfoManagerGetController/LoginTopInfo.easy?easybuyCallback=?";
	url = addHref(url);
	$.getJSON(url, "", function(data) {
		datas = data;
	});
	$.ajaxSettings.async = true;
	return datas;
}

function outLogin() {
	var url = "http://userManager.macaoeasybuy.com/userInfoManagerController/outTimeLogin.easy?easybuyCallback=?";
	var href = addHref(url);
	$.get(href, "", function(data) {
	});
}

function wxLogin() {
	window.location.href = "https://open.weixin.qq.com/connect/qrconnect?appid=wx47c5603ba720e93d&redirect_uri=https%3a%2f%2fwww.macaoeasybuy.com&response_type=code&scope=snsapi_login&state=STATE#wechat_redirect";
}
var key = "@vOW7dD0XA*PQKta1w2ZuQKLvr9D%OoA8Ol59wb06W&w!o1hH!#Waz!T";
// DES加密 DES加密和解密过程中，密钥长度都必须是8的倍数
function encryptByDES(message) {
	var keyHex = CryptoJS.enc.Utf8.parse(key);
	var encrypted = CryptoJS.DES.encrypt(message, keyHex, {
		mode : CryptoJS.mode.ECB,
		padding : CryptoJS.pad.Pkcs7
	});
	return encrypted.toString();
}
// 解密
function decryptByDES(ciphertext) {
	var keyHex = CryptoJS.enc.Utf8.parse(key);
	// direct decrypt ciphertext
	var decrypted = CryptoJS.DES.decrypt({
		ciphertext : CryptoJS.enc.Base64.parse(ciphertext)
	}, keyHex, {
		mode : CryptoJS.mode.ECB,
	// 这一步 是来填写 加密时候填充方式 padding: CryptoJS.pad.Pkcs7
	});
	return decrypted.toString(CryptoJS.enc.Utf8);
}
// map 結構
function Map() {
	this.values = new Array();
	this.put = function(key, val) {
		var data = {
			val : [ {
				keys : key,
				vals : val
			} ]
		};
		this.values[this.isKey(key)] = data;
	};
	this.get = function(key) {
		var len = this.isKey(key);
		var newValues = this.values[len];
		if (undefined != newValues) {
			newValues = newValues.val[0].vals;
			return newValues;
		} else {
			return "";
		}
	};
	this.isKey = function(key) {
		key = key + "";
		key = replaceAtre(key);
		key = key.toLowerCase();
		var len = key.length;
		var strs = 0;
		for ( var i = 0; i < len; i++) {
			var ins = key[i];
			if (!isNaN(ins)) {
				strs = parseInt(strs);
				ins = parseInt(ins);
				strs = ins * 2 + strs;
			} else {
				var int = ins.charCodeAt(ins);
				strs = parseInt(strs);
				strs = strs + int * 2;
			}
		}
		return strs;
	};
}
// 前綴和後綴
function prefixUrl() {
	var dataUrlA = $("a");
	var len = dataUrlA.length;
	var shoppingType = {
		xin : "xin",
		xian : "xian",
		liang : "liang",
		jiang : "jiang",
		re : "re"
	};
	var map = new Map();
	var shopping = new Map();
	shopping.put("0", "http://shopping.macaoeasybuy.com/");
	shopping.put("1", "http://shopping1.macaoeasybuy.com/");
	shopping.put("2", "http://shopping2.macaoeasybuy.com/");
	map.put("shopping", shopping);
	var social = new Map();
	social.put("0", "http://social.macaoeasybuy.com/");
	social.put("1", "http://social1.macaoeasybuy.com/");
	social.put("2", "http://social2.macaoeasybuy.com/");
	map.put("social", social);
	var userspace = new Map();
	userspace.put("0", "http://userspace.macaoeasybuy.com/");
	userspace.put("1", "http://userspace1.macaoeasybuy.com/");
	userspace.put("2", "http://userspace2.macaoeasybuy.com/");
	map.put("userspace", userspace);
	var index = new Map();
	index.put("0", "http://www.macaoeasybuy.com/");
	index.put("1", "http://www1.macaoeasybuy.com/");
	index.put("2", "http://www2.macaoeasybuy.com/");
	map.put("index", index);

	for ( var i = 0; i < len; i++) {
		var easys = dataUrlA[i];
		var prefix = $(easys).attr("data-prefix");
		var suffix = $(easys).attr("data-suffix");
		var Rand = Math.round(Math.random() * 2);
		var map1 = null;
		if (prefix == "shopping") {
			map1 = map.get("shopping");
			prefix = map1.get(Rand);
		} else if (prefix == "social") {
			map1 = map.get("social");
			prefix = map1.get(Rand);
		} else if (prefix == "userspace") {
			map1 = map.get("userspace");
			prefix = map1.get(Rand);
		} else if (prefix == "index") {
			map1 = map.get("index");
			prefix = map1.get(Rand);
		}

		if (suffix == "xin") {
			suffix = shoppingType.xin;
		} else if (suffix == "xian") {
			suffix = shoppingType.xian;
		} else if (suffix == "jiang") {
			suffix = shoppingType.jiang;
		} else if (suffix == "liang") {
			suffix = shoppingType.liang;
		} else if (suffix == "re") {
			suffix = shoppingType.re;
		}
		$(easys).attr("href", prefix + suffix);
	}
}