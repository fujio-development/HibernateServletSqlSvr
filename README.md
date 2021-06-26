## :octocat: サーブレットでHibernateを使いSQLServerとの読み書きサンプル
___
### 環境
```
開発環境：Eclipse 2021-06 R(4.20.0) Pleiades
言語：Java 11
デベロッパーSDK：Adopt OpenJDK 11.0.11 + 9
サーブレットコンテナ：Apache Tomcat 9.0.48
テンプレートエンジン：なし（JSP）
データベース：Microsoft SQLServer 2019 Express CU11  
-データベース管理ツール：Microsoft SQL Server Management Studio 18.9.1  
データベース接続：Microsoft JDBC Driver 9.2.1 for SQL Server  
O/R マッパー フレームワーク：Hibernate ORM 5.5.3 Final
CSSテンプレート：Bootstrap 5.0.2
```

#### 事前準備  
### サンプルプログラムを実行する際のデータベース作成  
Microsoft SQL Server Management Studioのクエリーで以下を実行するかこれ相当をデザイナで作成します。  

#### データベース作成(Microsoft SQL Server ManagementStudioでのデフォルト相当)  
※Microsoft SQL Server 2019 Express Editionで名前付きインスタンスが`SQLEXPRESS`の場合のクエリーです。  
別のインスタンス名やSQL Server 2017などのバージョンの場合はPathの**MSSQL15.SQLEXPRESS(ディレクトリ名)**  
が違いますのでご自身のディレクトリ名に合わせて下さい。  
```
use [master]
CREATE DATABASE HibernateSample
ON
(NAME=JdbcSample,FILENAME='C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\JdbcSample.mdf',SIZE=8MB,FILEGROWTH=64MB)
LOG ON
(NAME=HibernateSample_log,FILENAME='C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\HibernateSample_log.ldf',SIZE=8MB,FILEGROWTH=64MB)
	
ALTER DATABASE HibernateSample SET AUTO_CLOSE OFF
```

#### テーブル作成およびサンプルデータ  
Hibernateの機能および設定によりテーブルが無ければ作成しますので必要ありません。  
サンプルデータもプログラムでデータが１件も無ければ作成する様になっていますので必要ありません。  

#### SQL Server Configuration Manager  
[JDBCを使いMicrosoft SQL Serverへ接続する注意点 ](https://fujio-development.github.io/Contents/Java/JdbcSqlSvr)を参考にSQLServer BrowserとTCP/IPを有効にする必要があります。    

#### 画面・イメージ／一覧   
![Img](ReadmeImg.png)   

#### 画面・イメージ／例外   
![Img](ReadmeImg2.png)  

#### 画面・イメージ／ページなし   
![Img](ReadmeImg3.png)  