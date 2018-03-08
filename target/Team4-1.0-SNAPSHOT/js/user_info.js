
//删除事件
function del(obj){
    var trId=obj.parentNode.parentNode.id;
    var trObj=document.getElementById(trId);
    document.getElementById("table_body_id").removeChild(trObj);
}


