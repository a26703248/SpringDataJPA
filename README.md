# springdataparent
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
<table>
  <tr>
    <th>關聯註解</th>
    <th>預設FetchType</th>
  </tr>
  <tr>
    <td>@Basic</td>
    <td>FetchType.EARGE</td>
  </tr>
  <tr>
    <td>@OneToOnec</td>
    <td>FetchType.EARGE</td>
  </tr>
  <tr>
    <td>@ManyToOne</td>
    <td>FetchType.EARGE</td>
  </tr>
  <tr>
    <td>@OneToMany</td>
    <td>FetchType.LAZY</td>
  </tr>
  <tr>
    <td>@ManyToMany</td>
    <td>FetchType.LAZY</td>
  </tr>
</table>
