# Spring Data JPA

# Entity
1. Entity 必須要有無參建構子存在，不然搜尋會錯誤

# Column
1. name: 欄位對應資料庫名稱
2. unique(false): 是否為唯一值
3. nullable(true): 是否接受空值
4. insertable(true): 插入資料時是否包含該欄位
5. updatable(true): 更新資料時是否包含該欄位
6. columnDefinition: 生成資料表時使用輸入的字串生成欄位
7. table: 欄位所屬的資料表名稱
8. length(字串類行為255): 欄位大小
9. precision(0): 欄位對於整數精確度
10. scale(0): 欄位對於浮點數精確度

## GeneratedValue(strategy = GenerationType.xxx)
1. GenerationType.TABLE: 使用一個資料表紀錄所有主鍵
2. GenerationType.SEQUENCE: 依照資料表 sequence 生成
3. GenerationType.IDENTITY: 依照資料表自動生成不做介入
4. GenerationType.AUTO: 透過程式自動生成(雪花演算法)

## CascadeType
1. CascadeType.PERSIST: 在儲存時一併儲存 被參考的物件
2. CascadeType.MERGE: 在合併修改時一併 合併修改被參考的物件
3. CascadeType.REMOVE: 在移除時一併移除 被參考的物件
4. CascadeType.REFRESH: 在更新時一併更新 被參考的物件
5. CascadeType.ALL: 無論儲存、合併、 更新或移除，一併對被參考物件作出對應動作

## FetchType
1. FetchType.EARGE: 搜尋時一併搜尋關聯資料
2. 	FetchType.LAZY: 指搜尋當前物件資料

| 關聯註解 | 預設FetchTyp|
|-----------|---------------|
| @Basic|FetchType.EARGE|
|@OneToOne|FetchType.EARGE|
|@ManyToOne|FetchType.EARGE|
|@OneToMany|FetchType.LAZY|
|@ManyToMany|FetchType.LAZY|

## OneToOne and OneToMany
1. orphanRemoval(孤兒移除,預設false) : 當關聯物件變更為 null 時,將一併刪除
2. optional(預設true): 關聯對資料不能為空值
3. mapperBy: 統一由一方維護外鍵,值為另一方的屬性名稱

## JoinColumn
1. 設定外鍵欄位一方設定即可(通常設定在多筆資料對應那一方)

## @ManyToMany JoinTable(name="", joinColumns="", inverseJoinColumns="")
1. name : 中間資料表名稱(選填)
2. joinColumns : 本表關聯外鍵
3. inverseJoinColumns : 對方關聯外鍵(選填)

## MappedSuperclass
1. 只能標註於類別上
2. 備標註類別在資料庫中不會有實際表格

## AttributeOverride
1. 可針對繼承備標註為 MappedSuperclass 的欄位作複寫

## EntityListener(AuditingEntityListener)
1. 攔截被標註類別所有增刪修查動作

## CreatedBy、CreatedDate、LastModifiedBy、LastModifiedDate
1. 可自動給予創建作者、創建時間、最後修改時間、最後修改人
2. 需搭配 EntityListener 攔截

# Temporal
1. 給予時間戳格式
