# 申购系统api

## 公共部分

### 服务url前缀

/bigtrade-purchasing

### header参数

```json
"header": {
        "serviceName": "/voucher/enterVoucher",//接口
        "sender": null,//调用接口的服务器名
        "createTime": 1508740311177,//发送时间
        "provider": "bigtrade-finance",//本地提供的服务器名
        "statusCode": 2000,//操作代码
        "message": "请求成功",//操作详情
        "id": "827fa33b-2b30-45a7-8788-f26f418870f7"
    }
```

### 缺少参数返回

```json
{
    "header": {
        "serviceName": "/voucher/enterVoucher",
        "sender": null,
        "createTime": 1508740093506,
        "provider": "bigtrade-finance",
        "statusCode": 4001,
        "message": "缺少参数",
        "id": "1af7e130-1f1e-4901-9591-a01661e446c8"
    },
    "body": null
}
```

### 分页参数page

```json
	private Integer pageSize;//每页条数
	private Integer pageNum;//当前页数
	private String orderColumns;//拍序列
	private String desc;//升序 asc 倒序 desc
```

### 申购详情状态

```json
	step1(0, "第一步"),
	step2(1, "第二步"), 
	alreadyPublish(2, "已经发行"),
	cancle(3,"已经撤销"),
	allocated(4,"已经分配号");
```

### 发行计划状态

```json
	normal(0, "正常状态"),
	revoke(1,"撤销状态"),
	allocated(2,"已经分配了号"),
	lottery(3,"已经摇号"),
	failStep1(4,"失败第一步"),
	failStep2(5,"失败第二步"),
	auditSuccess(6,"审核成功"),
	auditFail(7,"审核失败"),
	holdsumChange(8,"持仓划转结束"),
	allEnd(9,"全部结束")
	;
```

### 手续费类型

```json
	no(0, "没有手续费"),
	rate(1, "使用费率"), 
	numerical(2, "使用数值");
```

## 2017-09接口部分

### 申请申购第一步

> 生成申请申购的基本信息，第一步之后由账户中心扣钱，进行第二步

| API URI           | 方法   |
| ----------------- | ---- |
| /apply/applyStep1 | POST |

| 参数          | 类型   | 注释       | 示例   | 不可空  |
| ----------- | ---- | -------- | ---- | ---- |
| commodityId | Long | 商品id     | 1    | y    |
| firmId      | Long | 用户标识id   | 1    | y    |
| count       | int  | 申购数量     | 20   | y    |
| issuanceId  | Long | 发行计划标识id | 1    | y    |

示例接口

```json

```

示例返回

```json

```

### 申请申购第二步

> 账户中心扣钱后，更改申购状态

| API URI           | 方法   |
| ----------------- | ---- |
| /apply/applyStep1 | POST |

| 参数               | 类型      | 注释       | 示例   | 不可空  |
| ---------------- | ------- | -------- | ---- | ---- |
| id               | Long    | 申购记录主键id | 1    | y    |
| result           | boolean | 申购结果     | ture | y    |
| financeAccountId | Long    | 资金结算账户   | 1    |      |

示例接口

```json

```

示例返回

```json

```

### 查询申购

> 查询申购的详细信息

| API URI                  | 方法   |
| ------------------------ | ---- |
| /apply/selectAppliaction | POST |

| 参数            | 类型     | 注释          | 示例                  | 不可空  |
| ------------- | ------ | ----------- | ------------------- | ---- |
| issuanceId    | Long   | 发行计划主键id    | 1                   |      |
| applicationId | Long   | 申购主键id      | 1                   |      |
| firmId        | Long   | 用户id        | 1                   |      |
| commodityId   | Long   | 商品id        | 1                   |      |
| startTime     | String | 申购委托时间大于该时间 | 2017-10-01 00:00:00 |      |
| endTime       | String | 申购委托时间小于该时间 | 2017-10-30 00:00:00 |      |

示例接口

```json
http://localhost:8093/bigtrade-purchasing/apply/selectAppliaction
```

示例返回

```json
{
    "header": {
        "serviceName": "/apply/selectAppliaction",
        "sender": null,
        "createTime": 1509346749604,
        "provider": "bigtrade-finance",
        "statusCode": 2000,
        "message": "请求成功",
        "id": "ae50d4e5-1f48-4d81-890f-ffc940bd5b8b"
    },
    "body": {
        "page": {
            "pageNum": 1,
            "pageSize": 10,
            "size": 10,
            "orderBy": null,
            "startRow": 1,
            "endRow": 10,
            "total": 12,
            "pages": 2,
            "list": [
                {
                    "id": 2,
                    "addTime": 1505201028000,
                    "deleteStatus": false,
                    "commodityId": 1,//商品id
                    "firmId": 1,//用户id
                    "issuanceplan_id": 5,//发行计划id
                    "count": 20,//申购数量
                    "totalAmount": 2000,//总钱数
                    "brokerage": 200,//手续费
                    "status": 1,//状态，见公共部分申购状态
                    "financeAccountId": 123456,//财务账户
                    "startNo": "0000000001",//摇号后，开始no
                    "endNo": "0000000020"//摇号后，结束no
                },
                {
                    "id": 3,
                    "addTime": 1505287433000,
                    "deleteStatus": false,
                    "commodityId": 1,
                    "firmId": 1,
                    "issuanceplan_id": 5,
                    "count": 20,
                    "totalAmount": 2000,
                    "brokerage": 200,
                    "status": 1,
                    "financeAccountId": 123456,
                    "startNo": "0000000021",
                    "endNo": "0000000040"
                }
            ],
            "firstPage": 1,
            "prePage": 0,
            "nextPage": 2,
            "lastPage": 2,
            "isFirstPage": true,
            "isLastPage": false,
            "hasPreviousPage": false,
            "hasNextPage": true,
            "navigatePages": 8,
            "navigatepageNums": [
                1,
                2
            ]
        }
    }
}
```

### 撤销申购

> 当业务主线已经将冻结资金释放完，该方法改变申购的状态为撤销状态

| API URI                  | 方法   |
| ------------------------ | ---- |
| /apply/revokeAppliaction | POST |

| 参数   | 类型   | 注释       | 示例   | 不可空  |
| ---- | ---- | -------- | ---- | ---- |
| id   | Long | 待撤销的申购id | 1    |      |

示例接口

```json

```

示例返回

```json

```

### 增加发行计划

> 增加发行计划

| API URI               | 方法   |
| --------------------- | ---- |
| /issuance/addIssuance | POST |

| 参数                    | 类型         | 注释                   | 示例                  | 不可空  |
| --------------------- | ---------- | -------------------- | ------------------- | ---- |
| commodityId           | Long       | 商品标识id               | 1                   | y    |
| commodityName         | String     | 发行计划名称               | 哈哈                  |      |
| planStartTime         | String     | 发行计划开始时间             | 2017-09-30 00:00:00 | y    |
| planEndTime           | String     | 发行计划结束时间             | 2017-10-01 23:59:59 | y    |
| lotteryTime           | String     | 摇号时间                 | 2017-10-02 00:00:00 |      |
| publicityStartTime    | String     | 公示期开始时间              | 2017-09-01 00:00:00 |      |
| publicityEndTime      | String     | 公示期结束时间              | 2017-09-29 00:00:00 |      |
| totalQuantity         | int        | 总发行数量                | 1000                | y    |
| maxSingleWinningCount | int        | 最大可中签数量              | 100                 | y    |
| unitPrice             | bigdecimal | 发行货物单价               | 2.02                | y    |
| publisherId           | Long       | 发布者标识id              | 1                   |      |
| brokerageType         | int        | 手续费类型（无为0，费率为1，数值为2） | 1                   | y    |
| brokerageRate         | bigdecimal | 手续费费率 （如果没有则传0）      | 0.5                 | y    |
| brokerage             | bigdecimal | 手续费 （如果没有则传0）        | 5                   | y    |
| operatorId            | Long       | 操作员标识                | 1                   | y    |
| operatorName          | String     | 操作员姓名                | 哈哈                  |      |
| operatiorIp           | String     | 操作员ip                | 192.168.11.1        | y    |
| notes                 | String     | 发行计划开始时间             | 这只是个测试              |      |


示例接口

```json

```

示例返回

```json

```

### 撤销发行计划

> 该发行计划还没有到开始时间才能撤销

| API URI                  | 方法   |
| ------------------------ | ---- |
| /issuance/revokeIssuance | POST |

| 参数   | 类型   | 注释       | 示例   | 不可空  |
| ---- | ---- | -------- | ---- | ---- |
| id   | Long | 发行计划标识id | 1    | y    |

示例接口

```json

```

示例返回

```json

```

### 查询发行计划里列表

| API URI                  | 方法   |
| ------------------------ | ---- |
| /issuance/selectIssuance | POST |

| 参数          | 类型    | 注释          | 示例   | 不可空  |
| ----------- | ----- | ----------- | ---- | ---- |
| commodityId | Long  | 商品标识id      | 1    |      |
| time        | Long  | 发行计划开始时间    | 1    |      |
| status      | int[] | 发行计划当前状态，见上 | 1    |      |
| page分页      |       | 见公共方法       |      | y    |

示例接口

```json
http://localhost:8093/bigtrade-purchasing/issuance/selectIssuance
```

示例返回

```json
{
    "header": {
        "serviceName": "/issuance/selectIssuance",
        "sender": null,
        "createTime": 1509347012155,
        "provider": "bigtrade-finance",
        "statusCode": 2000,
        "message": "请求成功",
        "id": "c4ddd745-ad51-48e3-9899-b7950d3151b9"
    },
    "body": {
        "page": {
            "pageNum": 1,
            "pageSize": 10,
            "size": 6,
            "orderBy": null,
            "startRow": 1,
            "endRow": 6,
            "total": 6,
            "pages": 1,
            "list": [
                {
                    "count": 144,//已申购成功的数量
                    "operatorId": 1,//操作人id
                    "maxApplicationCount": 20,//单人最大申购数量
                    "brokerage": 0,//固定手续费
                    "unitPrice": 100,//货品单价
                    "maxSingleWinningCount": 0,//最大中签数量
                    "publicityStartTime": 1504022400000,//公示期开始时间
                    "id": 5,//发行计划id
                    "allocateUserIp": "192.168.1.14",//摇号人ip
                    "lotteryTime": 1509019563000,//摇号时间
                    "planStartTime": 1504195200000,//计划开始时间
                    "allocateUserName": "测试摇号",//摇号人姓名
                    "applicationCount": 150,//申购数量
                    "publicityEndTime": 1508759181000,//公示期开始时间
                    "allocateUserId": 1,//摇号人id
                    "planEndTime": 1506787199000,//计划结束时间
                    "brokerageType": 1,//手续费类型
                    "brokerageRate": 0.1,//手续费费率
                    "totalQuantity": 100,//总发行数量
                    "publisherId": 1,//发布人
                    "status": 3,//状态 见公共部分发行计划状态
                    "commodityName": "测试商品",//发行计划名称
                    "deleteStatus": false,
                    "operatorIp": "192.168.1.14",//操作人ip
                    "operatorName": "test",//操作人姓名
                    "commodityId": 1,//商品id
                    "notes": "我来测试",//备注
                    "addTime": 1505283167000
                },
                {
                    "brokerageRate": 0.1,
                    "totalQuantity": 100,
                    "publisherId": 1,
                    "count": 0,
                    "operatorId": 1,
                    "status": 0,
                    "maxApplicationCount": 20,
                    "brokerage": 0,
                    "maxSingleWinningCount": 0,
                    "unitPrice": 100,
                    "commodityName": "测试商品2",
                    "deleteStatus": false,
                    "publicityStartTime": 1504022400000,
                    "id": 6,
                    "operatorIp": "192.168.1.14",
                    "operatorName": "test",
                    "planStartTime": 1504195200000,
                    "applicationCount": 0,
                    "publicityEndTime": 1508759184000,
                    "notes": "我来测试",
                    "commodityId": 2,
                    "brokerageType": 1,
                    "addTime": 1505283197000,
                    "planEndTime": 1506787199000
                }
            ],
            "firstPage": 1,
            "prePage": 0,
            "nextPage": 0,
            "lastPage": 1,
            "isFirstPage": true,
            "isLastPage": true,
            "hasPreviousPage": false,
            "hasNextPage": false,
            "navigatePages": 8,
            "navigatepageNums": [
                1
            ]
        }
    }
}
```

### 发行摇号的方法

| API URI                 | 方法   |
| ----------------------- | ---- |
| /issuance/lotterySystem | POST |

| 参数           | 类型     | 注释     | 示例           | 不可空  |
| ------------ | ------ | ------ | ------------ | ---- |
| id           | Long   | 发行计划id | 1            | y    |
| operatorid   | Long   | 操作人id  | 1            | y    |
| operatorname | String | 操作人名称  | 测试摇号         | y    |
| operatorip   | String | 操作人ip  | 192.188.1.31 | y    |

示例接口

```json

```

示例返回

```json

```

### 为准备摇号的发行计划分配号码

| API URI                  | 方法   |
| ------------------------ | ---- |
| /issuance/allocateNumber | POST |

| 参数           | 类型     | 注释     | 示例           | 不可空  |
| ------------ | ------ | ------ | ------------ | ---- |
| planid       | Long   | 发行计划id | 1            | y    |
| operatorid   | Long   | 操作人id  | 1            | y    |
| operatorname | String | 操作人名称  | 测试摇号         | y    |
| operatorip   | String | 操作人ip  | 192.188.1.31 | y    |

示例接口

```json

```

示例返回

```json

```

### 查询摇号结果

> 查询摇号结果，形如：末尾3位为“012”，末尾4位为“0314”

| API URI                       | 方法   |
| ----------------------------- | ---- |
| /issuance/selectLotteryResult | POST |

| 参数   | 类型   | 注释     | 示例   | 不可空  |
| ---- | ---- | ------ | ---- | ---- |
| id   | Long | 发行计划id | 1    | y    |

示例接口

```json
http://localhost:8093/bigtrade-purchasing/issuance/selectLotteryResult?id=5
```

示例返回

```json
{
    "header": {
        "serviceName": "/issuance/selectLotteryResult",
        "sender": null,
        "createTime": 1509347365560,
        "provider": "bigtrade-finance",
        "statusCode": 2000,
        "message": "请求成功",
        "id": "d9531ee2-ecb0-4c19-8c63-36a95ab123fb"
    },
    "body": {
        "page": {
            "pageNum": 1,
            "pageSize": 10,
            "size": 1,
            "orderBy": null,
            "startRow": 1,
            "endRow": 1,
            "total": 1,
            "pages": 1,
            "list": [
                {
                    "id": 11,
                    "addTime": 1505902900000,
                    "deleteStatus": false,
                    "issuanceplan_id": 5,//计划id
                    "winningRate": 0.6667,//中签率
                    "operatorId": 1,//操作人id
                    "operatorName": "测试名称",//操作人姓名
                    "operatorIp": "192",//操作人ip
                    "lotteryResult": "0000000004,0000000005,0000000006,0000000007,0000000008,0000000009,0000000010,0000000014,0000000015,0000000016,0000000017,0000000018,0000000019,0000000020,0000000023,0000000024,0000000025,0000000026,0000000027,0000000028,0000000029,0000000030,0000000034,0000000035,0000000036,0000000037,0000000038,0000000039,0000000044,0000000045,0000000046,0000000047,0000000048,0000000049,0000000054,0000000055,0000000056,0000000057,0000000058,0000000059,0000000064,0000000065,0000000066,0000000067,0000000068,0000000069,0000000070,0000000074,0000000075,0000000076,0000000077,0000000078,0000000079,0000000081,0000000084,0000000085,0000000086,0000000087,0000000088,0000000089,0000000092,0000000094,0000000095,0000000096,0000000097,0000000098,0000000099,0000000104,0000000105,0000000106,0000000107,0000000108,0000000109,0000000110,0000000114,0000000115,0000000116,0000000117,0000000118,0000000119,0000000123,0000000124,0000000125,0000000126,0000000127,0000000128,0000000129,0000000130,0000000134,0000000135,0000000136,0000000137,0000000138,0000000139,0000000144,0000000145,0000000146,0000000147,0000000148,0000000149",//摇号具体结果
                    "lotteryResultShow": "末“1”位数：7、6、8、5、9、4,末“2”位数：92、30、70、10、81、23,末“3”位数：020"//摇号结果
                }
            ],
            "firstPage": 1,
            "prePage": 0,
            "nextPage": 0,
            "lastPage": 1,
            "isFirstPage": true,
            "isLastPage": true,
            "hasPreviousPage": false,
            "hasNextPage": false,
            "navigatePages": 8,
            "navigatepageNums": [
                1
            ]
        }
    }
}
```

### 查询摇号结果详情

> 查询摇号结果详情

| API URI                             | 方法   |
| ----------------------------------- | ---- |
| /issuance/selectLotteryResultDetail | POST |

| 参数     | 类型   | 注释     | 示例   | 不可空  |
| ------ | ---- | ------ | ---- | ---- |
| id     | Long | 发行计划id | 1    | y    |
| page分页 |      | 分页见上   |      |      |

示例接口

```json
http://localhost:8093/bigtrade-purchasing/issuance/selectLotteryResultDetail?id=5
```

示例返回

```json
{
    "header": {
        "serviceName": "/issuance/selectLotteryResultDetail",
        "sender": null,
        "createTime": 1509347453348,
        "provider": "bigtrade-finance",
        "statusCode": 2000,
        "message": "请求成功",
        "id": "bebfed85-e847-4978-87b5-07bcd59df516"
    },
    "body": {
        "page": {
            "pageNum": 1,
            "pageSize": 10,
            "size": 10,
            "orderBy": null,
            "startRow": 1,
            "endRow": 10,
            "total": 100,
            "pages": 10,
            "list": [
                {
                    "id": 202,
                    "addTime": 1505902900000,
                    "deleteStatus": false,
                    "issuanceplan_id": 5,//计划id
                    "winningNo": "0000000004",//中签号
                    "applicationdetail_id": 2//对应申购id
                },
                {
                    "id": 203,
                    "addTime": 1505902900000,
                    "deleteStatus": false,
                    "issuanceplan_id": 5,
                    "winningNo": "0000000005",
                    "applicationdetail_id": 2
                }
            ],
            "firstPage": 1,
            "prePage": 0,
            "nextPage": 2,
            "lastPage": 8,
            "isFirstPage": true,
            "isLastPage": false,
            "hasPreviousPage": false,
            "hasNextPage": true,
            "navigatePages": 8,
            "navigatepageNums": [
                1,
                2,
                3,
                4,
                5,
                6,
                7,
                8
            ]
        }
    }
}
```

### 发行失败第一步

> 当已经有申购情况后，才能失败，失败分两步，第一步返回所有申购委托单

| API URI             | 方法   |
| ------------------- | ---- |
| /issuance/failStep1 | POST |

| 参数           | 类型     | 注释     | 示例           | 不可空  |
| ------------ | ------ | ------ | ------------ | ---- |
| id           | Long   | 发行计划id | 1            | y    |
| operatorid   | Long   | 操作人id  | 1            | y    |
| operatorname | String | 操作人名称  | 测试摇号         | y    |
| operatorip   | String | 操作人ip  | 192.188.1.31 | y    |

示例接口

```json

```

示例返回

```json

```

### 发行失败第二步

> 第一步后，账户中心根据返回的列表释放资金，然后第二步更新申购状态

| API URI             | 方法   |
| ------------------- | ---- |
| /issuance/failStep2 | POST |

| 参数   | 类型   | 注释     | 示例   | 不可空  |
| ---- | ---- | ------ | ---- | ---- |
| id   | Long | 发行计划id | 1    | y    |

示例接口

```json

```

示例返回

```json

```

### 审核

| API URI         | 方法   |
| --------------- | ---- |
| /issuance/audit | POST |

| 参数          | 类型     | 注释          | 示例          | 不可空  |
| ----------- | ------ | ----------- | ----------- | ---- |
| id          | Long   | 待审核的发行计划id  | 1           | y    |
| states      | int    | 6审核成功，7审核失败 | 6           | y    |
| auditorId   | Long   | 审核人id       | 1           | y    |
| auditorName | String | 审核人姓名       | 测试审核        | y    |
| auditorIp   | String | 审核人ip       | 192.168.1.1 | y    |

示例接口

```json

```

示例返回

```json

```

## 2017-10接口部分

### 查询个人申购详情

> 查询个人申购基本信息（申购详情，计划详情）

| API URI                        | 方法   |
| ------------------------------ | ---- |
| /apply/selectApplicationDetail | POST |

| 参数   | 类型   | 注释     | 示例   | 不可空  |
| ---- | ---- | ------ | ---- | ---- |
| id   | Long | 申购详情id | 1    | y    |

示例接口
```json
http://localhost:8093/bigtrade-purchasing/apply/selectApplicationDetail?id=8
```

示例返回

```json
{
    "header": {
        "serviceName": "/apply/selectApplicationDetail",
        "sender": null,
        "createTime": 1509334051476,
        "provider": "bigtrade-finance",
        "statusCode": 2000,
        "message": "请求成功",
        "id": "e67d43d8-2694-4494-857a-bbe99fdc3a96"
    },
    "body": {
        "application": {//申购详情
            "id": 8,//申购记录id
            "addTime": 1505287461000,
            "deleteStatus": false,
            "commodityId": 1,//申购商品id
            "firmId": 8,//申购用户id
            "issuanceplan_id": 5,//申购计划id
            "count": 8,//申购数量
            "totalAmount": 800,//总价格
            "brokerage": 80,//申购手续费
            "status": 1,//申购状态 详见申购详情状态
            "financeAccountId": 123456,//财务账户
            "startNo": "0000000084",//摇号后被分配的开始号码
            "endNo": "0000000091"//号妖后被分配的结束号码
        },
        "plan": {//发行计划详情
            "id": 5,
            "addTime": 1505283167000,
            "deleteStatus": false,
            "commodityId": 1,//商品id
            "commodityName": "测试商品",//发行计划名称
            "planStartTime": 1504195200000,//发行计划开始时间，也就是能申购开始时间
            "planEndTime": 1506787199000,//发行计划结束时间，也就是能申购结束时间
            "publicityStartTime": 1504022400000,//公示期开始时间
            "status": 3,//状态 详见发行计划状态
            "totalQuantity": 100,//总数量
            "maxSingleWinningCount": 0,//最大中签数量
            "unitPrice": 100,//货物单价
            "publisherId": 1,
            "brokerageType": 1,
            "brokerageRate": 0.1,
            "brokerage": 0,
            "operatorId": 1,
            "operatorName": "test",
            "operatorIp": "192.168.1.14",
            "applicationCount": 150,//已经申购数量
            "allocateUserId": 1,
            "allocateUserName": "测试摇号",
            "allocateUserIp": "192.168.1.14",
            "maxApplicationCount": 20,
            "auditorId": null,
            "auditorName": null,
            "auditorIp": null,
            "lotteryTime": 1509019563000,//摇号日期
            "publicityEndTime": 1508759181000,//公示期结束时间
            "notes": "我来测试"
        }
    }
}
```
### 查询发行计划详情

> 查询一个商品的发行计划详情

| API URI                     | 方法   |
| --------------------------- | ---- |
| /issuance/selectIssuanceOne | POST |

| 参数   | 类型   | 注释     | 示例   | 不可空  |
| ---- | ---- | ------ | ---- | ---- |
| id   | Long | 发行计划id | 1    | y    |

示例接口
```json
http://localhost:8093/bigtrade-purchasing/issuance/selectIssuanceOne?id=9
```

示例返回

```json
{
    "header": {
        "serviceName": "/issuance/selectIssuanceOne",
        "sender": null,
        "createTime": 1509343160316,
        "provider": "bigtrade-finance",
        "statusCode": 2000,
        "message": "请求成功",
        "id": "98113c57-7dd8-46e8-96f5-4a8d14dcc944"
    },
    "body": {
        "issuance": {
            "id": 9,
            "addTime": 1505798980000,
            "deleteStatus": false,
            "commodityId": 1,//发行商品id
            "commodityName": "测试",//发行计划名字
            "planStartTime": 1504195200000,//计划(可申购)开始时间
            "planEndTime": 1506787199000,//计划(可申购)结束时间
            "publicityStartTime": 1504022400000,//公示期开始时间
            "status": 0,//状态，详见发行计划状态
            "totalQuantity": 1000,//总共发行数量
            "maxSingleWinningCount": 10,//单个交易会员最大的中签数量
            "unitPrice": 100,//货品单价
            "publisherId": 1,//发布人id
            "brokerageType": 2,//手续费类型 见公共部分
            "brokerageRate": 0,//手续费费率 当type为1的时候使用
            "brokerage": 10,//固定手续费 当type为2的时候使用
            "operatorId": 1,//操作员id
            "operatorName": "测试日志",//操作员姓名
            "operatorIp": "192.168.1.14",//操作员ip
            "applicationCount": 0,//已申购数量
            "allocateUserId": null,//摇号人id
            "allocateUserName": null,//摇号人name
            "allocateUserIp": null,//摇号人ip
            "maxApplicationCount": 10,//单个交易会员最大申购数量
            "auditorId": null,//审核人id
            "auditorName": null,//审核人名字
            "auditorIp": null,//审核人ip
            "lotteryTime": null,//摇号时间
            "publicityEndTime": 1508759192000,//公示期结束时间
            "notes": "呵呵"
        }
    }
}
```

### 更新发行计划状态

> 更新发行计划的状态

| API URI                        | 方法   |
| ------------------------------ | ---- |
| /issuance/updateIssuanceStatus | POST |

| 参数     | 类型   | 注释     | 示例   | 不可空  |
| ------ | ---- | ------ | ---- | ---- |
| id     | Long | 发行计划id | 1    | y    |
| status | int  | 更新到的状态 | 1    | y    |

示例接口

```json
http://localhost:8093/bigtrade-purchasing/issuance/updateIssuanceStatus?id=10&status=1
```

示例返回

```json
{
    "header": {
        "serviceName": "/issuance/updateIssuanceStatus",
        "sender": null,
        "createTime": 1509516777663,
        "provider": "bigtrade-finance",
        "statusCode": 2000,
        "message": "请求成功",
        "id": "ffc2312f-63c9-4204-bcdd-9bcd839549cc"
    },
    "body": {
        "issuance": {
            "id": 10,
            "addTime": 1508759351000,
            "deleteStatus": false,
            "commodityId": 1,
            "commodityName": "测试时间",
            "planStartTime": 1504195200000,
            "planEndTime": 1510329599000,
            "publicityStartTime": 1510329600000,
            "status": 1,
            "totalQuantity": 1000,
            "maxSingleWinningCount": 1,
            "unitPrice": 100,
            "publisherId": null,
            "brokerageType": 0,
            "brokerageRate": 0,
            "brokerage": 0,
            "operatorId": 1,
            "operatorName": "测试",
            "operatorIp": "192.168.1.14",
            "applicationCount": 0,
            "allocateUserId": null,
            "allocateUserName": null,
            "allocateUserIp": null,
            "maxApplicationCount": 1,
            "auditorId": 1,
            "auditorName": "0:0:0:0:0:0:0:1",
            "auditorIp": "管理员",
            "lotteryTime": 1509206400000,
            "publicityEndTime": 1510502399000,
            "notes": null
        }
    }
}
```

### 删除发行计划状态

> 删除发行计划的状态,只有状态为下面的,才可已撤销
> 正常状态normal(0)，撤消状态revoke(1)，审核失败状态auditFail(7)，失败第二步状态failStep2(5)

| API URI                  | 方法   |
| ------------------------ | ---- |
| /issuance/deleteIssuance | POST |

| 参数   | 类型   | 注释     | 示例   | 不可空  |
| ---- | ---- | ------ | ---- | ---- |
| id   | Long | 发行计划id | 1    | y    |

示例接口

```json
http://localhost:8093/bigtrade-purchasing/issuance/deleteIssuance?id=9
```

示例返回

```json

```

## 2017-11-02接口

### 查询我的当前申购

| API URI                           | 方法   |
| --------------------------------- | ---- |
| /apply/selectMyNowAppliactionList | POST |

| 参数       | 类型      | 注释   | 示例   | 不可空  |
| -------- | ------- | ---- | ---- | ---- |
| userid   | Long    | 用户id | 1    | y    |
| pageSize | Integer | 每页条数 | 1    | y    |
| pageNum  | Integer | 当前页数 | 1    | y    |

示例接口

```json
http://localhost:8093/bigtrade-purchasing/apply/selectMyNowAppliactionList?userid=175&pageSize=2&pageNum=1
```

示例返回

```json
{
    "header": {
        "serviceName": "/apply/selectMyNowAppliactionList",
        "sender": null,
        "createTime": 1509607196077,
        "provider": "bigtrade-finance",
        "statusCode": 2000,
        "message": "请求成功",
        "id": "6a9eac35-f541-41a9-a166-3b162633fe32"
    },
    "body": {
        "rlist": {
            "pageNum": 1,
            "pageSize": 2,
            "size": 2,
            "orderBy": "addTime desc",
            "startRow": 1,
            "endRow": 2,
            "total": 10,
            "pages": 5,
            "list": [
                {
                    "id": 39,
                    "addTime": 1509605596000,
                    "deleteStatus": false,
                    "commodityId": 2,
                    "firmId": 175,
                    "issuanceplan_id": 11,
                    "count": 3,
                    "totalAmount": 3,
                    "brokerage": 0,
                    "status": 1,
                    "financeAccountId": 10,
                    "startNo": null,
                    "endNo": null,
                    "winCount": 0
                },
                {
                    "id": 38,
                    "addTime": 1509605588000,
                    "deleteStatus": false,
                    "commodityId": 2,
                    "firmId": 175,
                    "issuanceplan_id": 11,
                    "count": 2,
                    "totalAmount": 2,
                    "brokerage": 0,
                    "status": 1,
                    "financeAccountId": 10,
                    "startNo": null,
                    "endNo": null,
                    "winCount": 0
                }
            ],
            "firstPage": 1,
            "prePage": 0,
            "nextPage": 2,
            "lastPage": 5,
            "isFirstPage": true,
            "isLastPage": false,
            "hasPreviousPage": false,
            "hasNextPage": true,
            "navigatePages": 8,
            "navigatepageNums": [
                1,
                2,
                3,
                4,
                5
            ]
        }
    }
}
```

### 查询我的历史申购

| API URI                               | 方法   |
| ------------------------------------- | ---- |
| /apply/selectMyHistoryAppliactionList | POST |

| 参数       | 类型      | 注释   | 示例   | 不可空  |
| -------- | ------- | ---- | ---- | ---- |
| userid   | Long    | 用户id | 1    | y    |
| pageSize | Integer | 每页条数 | 1    | y    |
| pageNum  | Integer | 当前页数 | 1    | y    |

示例接口

```json
http://localhost:8093/bigtrade-purchasing/apply/selectMyHistoryAppliactionList?userid=175&pageSize=2&pageNum=1
```

示例返回

```json
{
    "header": {
        "serviceName": "/apply/selectMyNowAppliactionList",
        "sender": null,
        "createTime": 1509607196077,
        "provider": "bigtrade-finance",
        "statusCode": 2000,
        "message": "请求成功",
        "id": "6a9eac35-f541-41a9-a166-3b162633fe32"
    },
    "body": {
        "rlist": {
            "pageNum": 1,
            "pageSize": 2,
            "size": 2,
            "orderBy": "addTime desc",
            "startRow": 1,
            "endRow": 2,
            "total": 10,
            "pages": 5,
            "list": [
                {
                    "id": 39,
                    "addTime": 1509605596000,
                    "deleteStatus": false,
                    "commodityId": 2,
                    "firmId": 175,
                    "issuanceplan_id": 11,
                    "count": 3,
                    "totalAmount": 3,
                    "brokerage": 0,
                    "status": 1,
                    "financeAccountId": 10,
                    "startNo": null,
                    "endNo": null,
                    "winCount": 0
                },
                {
                    "id": 38,
                    "addTime": 1509605588000,
                    "deleteStatus": false,
                    "commodityId": 2,
                    "firmId": 175,
                    "issuanceplan_id": 11,
                    "count": 2,
                    "totalAmount": 2,
                    "brokerage": 0,
                    "status": 1,
                    "financeAccountId": 10,
                    "startNo": null,
                    "endNo": null,
                    "winCount": 0
                }
            ],
            "firstPage": 1,
            "prePage": 0,
            "nextPage": 2,
            "lastPage": 5,
            "isFirstPage": true,
            "isLastPage": false,
            "hasPreviousPage": false,
            "hasNextPage": true,
            "navigatePages": 8,
            "navigatepageNums": [
                1,
                2,
                3,
                4,
                5
            ]
        }
    }
}
```

## 11.03部分接口

### 撤销申购补偿接口

> 补偿接口必须是已经为撤销的申购才能补偿，如果不是，则不能补偿

| API URI                             | 方法   |
| ----------------------------------- | ---- |
| /apply/revokeAppliaction_compensate | POST |

| 参数   | 类型   | 注释         | 示例   | 不可空  |
| ---- | ---- | ---------- | ---- | ---- |
| id   | Long | 待撤销补偿的申购id | 1    |      |

示例接口

```json
http://localhost:8093/bigtrade-purchasing/apply/revokeAppliaction_compensate?id=44
```

示例返回

```json
{
    "header": {
        "serviceName": "/apply/revokeAppliaction_compensate",
        "sender": null,
        "createTime": 1509690276354,
        "provider": "bigtrade-finance",
        "statusCode": 2000,
        "message": "请求成功",
        "id": "0280d219-006f-43eb-9c8c-5760c2c8af8b"
    },
    "body": {
        "count": 1
    }
}
```

## 11.16接口

### 查询我的全部申购（带计划的部分信息）

| API URI                           | 方法   |
| --------------------------------- | ---- |
| /apply/selectMyAllAppliactionList | POST |

| 参数       | 类型      | 注释   | 示例   | 不可空  |
| -------- | ------- | ---- | ---- | ---- |
| userid   | Long    | 用户id | 1    | y    |
| pageSize | Integer | 每页条数 | 1    | y    |
| pageNum  | Integer | 当前页数 | 1    | y    |

示例接口

```json
http://localhost:8093/bigtrade-purchasing/apply/selectMyAllAppliactionList?userid=159
```

示例返回

```json
{
    "header": {
        "serviceName": "/apply/selectMyAllAppliactionList",
        "sender": null,
        "createTime": 1510805309456,
        "provider": "bigtrade-finance",
        "statusCode": 2000,
        "message": "请求成功",
        "id": "70c78404-1552-49ef-a8bb-ccdc418ba08b"
    },
    "body": {
        "rlist": {
            "pageNum": 1,
            "pageSize": 10,
            "size": 5,
            "orderBy": "addTime desc",
            "startRow": 1,
            "endRow": 5,
            "total": 5,
            "pages": 1,
            "list": [
                {
                    "id": 5,
                    "addTime": 1510737684000,
                    "deleteStatus": false,
                    "commodityId": 1,
                    "firmId": 159,//用户id
                    "issuanceplan_id": 4,//计划id
                    "count": 5,//用户本条申购的数量
                    "totalAmount": 251,//用户本条申购的总钱数
                    "brokerage": 50.2,//用户本条使用手续费
                    "status": 1,//本条申购的状态
                    "financeAccountId": 21,//本条申购的财务账号
                    "startNo": "",//分配号后，分配的开始号码
                    "endNo": "",//分配号后，分配的结束号码
                    "winCount": 0,//摇号后，中签数量
                    "planStatus": 1,//所属计划的状态
                    "planUnitPrice": 10,//所属计划的单价
                    "planLotteryTime": 1510801263000,//所属计划的摇号时间
                    "planTotalQuqntity": 1000,//所属计划的总数量
                    "planMaxSingleWinningCount": 1,//所属计划的最大中签实数量
                    "planStartTime": 1510714807000,//所属计划的申购开始时间
                    "planEndTime": 1510801210000//所属计划的申购结束时间
                }
            ],
            "firstPage": 1,
            "prePage": 0,
            "nextPage": 0,
            "lastPage": 1,
            "isFirstPage": true,
            "isLastPage": true,
            "hasPreviousPage": false,
            "hasNextPage": false,
            "navigatePages": 8,
            "navigatepageNums": [
                1
            ]
        }
    }
}
```

## 11.27接口

### 查询用户显示的计划

> 与selectAppliaction的区别为，增加了判断条件，判断当前时间是否在公示期之间，或者是否在计划可申购时间之后

| API URI                             | 方法   |
| ----------------------------------- | ---- |
| /issuance/selectIssuanceForUserShow | POST |

| 参数          | 类型    | 注释          | 示例   | 不可空  |
| ----------- | ----- | ----------- | ---- | ---- |
| commodityId | Long  | 商品标识id      | 1    |      |
| time        | Long  | 发行计划开始时间    | 1    |      |
| status      | int[] | 发行计划当前状态，见上 | 1    |      |
| page分页      |       | 见公共方法       |      | y    |

示例接口

```json
http://localhost:8093/bigtrade-purchasing/issuance/selectIssuanceForUserShow
```

示例返回

```json
{
    "header": {
        "serviceName": "/issuance/selectIssuanceForUserShow",
        "sender": null,
        "createTime": 1511765613165,
        "provider": "bigtrade-finance",
        "statusCode": 2000,
        "message": "请求成功",
        "id": "9be0cbf2-ea7d-4d47-9311-f181a459c5e7"
    },
    "body": {
        "page": {
            "pageNum": 1,
            "pageSize": 10,
            "size": 10,
            "orderBy": "addTime desc",
            "startRow": 1,
            "endRow": 10,
            "total": 11,
            "pages": 2,
            "list": [
                {
                     "count": 144,//已申购成功的数量
                    "operatorId": 1,//操作人id
                    "maxApplicationCount": 20,//单人最大申购数量
                    "brokerage": 0,//固定手续费
                    "unitPrice": 100,//货品单价
                    "maxSingleWinningCount": 0,//最大中签数量
                    "publicityStartTime": 1504022400000,//公示期开始时间
                    "id": 5,//发行计划id
                    "allocateUserIp": "192.168.1.14",//摇号人ip
                    "lotteryTime": 1509019563000,//摇号时间
                    "planStartTime": 1504195200000,//计划开始时间
                    "allocateUserName": "测试摇号",//摇号人姓名
                    "applicationCount": 150,//申购数量
                    "publicityEndTime": 1508759181000,//公示期开始时间
                    "allocateUserId": 1,//摇号人id
                    "planEndTime": 1506787199000,//计划结束时间
                    "brokerageType": 1,//手续费类型
                    "brokerageRate": 0.1,//手续费费率
                    "totalQuantity": 100,//总发行数量
                    "publisherId": 1,//发布人
                    "status": 3,//状态 见公共部分发行计划状态
                    "commodityName": "测试商品",//发行计划名称
                    "deleteStatus": false,
                    "operatorIp": "192.168.1.14",//操作人ip
                    "operatorName": "test",//操作人姓名
                    "commodityId": 1,//商品id
                    "notes": "我来测试",//备注
                    "addTime": 1505283167000
                },
                {
                    "brokerageRate": 0.1,
                    "totalQuantity": 100,
                    "publisherId": 1,
                    "count": 0,
                    "operatorId": 1,
                    "status": 0,
                    "maxApplicationCount": 20,
                    "brokerage": 0,
                    "maxSingleWinningCount": 0,
                    "unitPrice": 100,
                    "commodityName": "测试商品2",
                    "deleteStatus": false,
                    "publicityStartTime": 1504022400000,
                    "id": 6,
                    "operatorIp": "192.168.1.14",
                    "operatorName": "test",
                    "planStartTime": 1504195200000,
                    "applicationCount": 0,
                    "publicityEndTime": 1508759184000,
                    "notes": "我来测试",
                    "commodityId": 2,
                    "brokerageType": 1,
                    "addTime": 1505283197000,
                    "planEndTime": 1506787199000
                }
            ],
            "firstPage": 1,
            "prePage": 0,
            "nextPage": 2,
            "lastPage": 2,
            "isFirstPage": true,
            "isLastPage": false,
            "hasPreviousPage": false,
            "hasNextPage": true,
            "navigatePages": 8,
            "navigatepageNums": [
                1,
                2
            ]
        }
    }
}
```