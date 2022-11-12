<?php
header("Content-Type: text/html;charset=utf-8");
$fileInfo=$_FILES['data'];//获取提交过来的文件
$filename=$fileInfo['name'];//获取文件名
$filePath=$fileInfo['tmp_name'];//获取文件临时目录
$name = iconv('utf-8', 'gb2312', $filename);//把文件名重新编码，避免吗中文乱码
move_uploaded_file($filePath,"./".$name);
echo($filename);