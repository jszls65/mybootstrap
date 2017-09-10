use mybootstrap;
db.userinfo.insert({userId:'zls',userName:'张连胜',password:'123',addr:'南京',age:'27'});

db.userinfo.find();


db.sysparams.insert({code:'login-200',desc:'登录成功。'});
db.sysparams.insert({code:'500',desc:'服务器发生错误！'});
db.sysparams.insert({code:'login-404',desc:'登录失败，用户名或密码错误！'});

db.sysparams.find();