/**
 *  数据库名字
 *	数据库版本号
 *	显示名字
 *	数据库保存数据的大小（以字节为单位 )
 *	回调函数（非必须)
 */
var db = openDatabase('Databases', '1.0', 'Test DB', 2 * 1024 * 1024);
if(!db) {
	alert("数据库创建失败！");
} else {
	alert("数据库创建成功！");
}

/**
 * 创建表
 * 
 * executeSql函数有四个参数，其意义分别是：
 *	1）表示查询的字符串，使用的SQL语言是SQLite 3.6.19。（必选）
 *	2）插入到查询中问号所在处的字符串数据。（可选）
 *	3）成功时执行的回调函数。返回两个参数：tx和执行的结果。（可选）
 *	4）一个失败时执行的回调函数。返回两个参数：tx和失败的错误信息。（可选）
 */
var createTable = function() {
	db.transaction(function(tx) {
		tx.executeSql('CREATE TABLE IF NOT EXISTS userTable(user_id integer primary key AutoIncrement,user_name varchar(20) not null,user_remark varchar(20) null,user_status integer not null default 0,group_id integer not null)', [], function(tx, result) { 
			alert('创建stu表成功'); 
		}, function(tx, error) {
			alert('创建stu表失败:' + error.message);
		});
	});
};

/**
 * 向表中插入数据
 */
var insertTable = function(){
	db.transaction(function (tx) {
		tx.executeSql("insert into userTable values(?,?,?,?,? )", [3, '徐明祥', '', 1, 1], function () { alert('添加数据成功'); }, function (tx, error) { 
			alert('添加数据失败: ' + error.message);
		});
	});
};

/**
 * 查询表中数据
 */
var queryTable = function(){
	db.transaction(function (tx) {
		tx.executeSql("select * from stu", [], function (tx, result) { //执行成功的回调函数
		//在这里对result 做你想要做的事情吧...........
		},function (tx, error) {
			alert('查询失败: ' + error.message);
		});
	});
};


/**
 * 根据条件修改表中数据
 * @param {Object} id 
 * @param {Object} name
 */
var updateTable = function(id, name){
	db.transaction(function (tx) {
		tx.executeSql("update stu set name = ? where id= ?", [], function (tx, result) { //执行成功的回调函数
		//在这里对result 做你想要做的事情吧...........
		},function (tx, error) {
			alert('查询失败: ' + error.message);
		});
	});
};

/**
 * 根据条件删除表数据中
 * @param {Object} id
 */
var deleteTable = function(id){
	db.transaction(function (tx) {
		tx.executeSql("delete from stu where id= ?", [], function (tx, result) { //执行成功的回调函数
		//在这里对result 做你想要做的事情吧...........
		},function (tx, error) {
			alert('查询失败: ' + error.message);
		});
	});
};

/**
 */
var dropTable = function () {
	dataBase.transaction(function (tx) {
		tx.executeSql('drop table stu');
	});
};
