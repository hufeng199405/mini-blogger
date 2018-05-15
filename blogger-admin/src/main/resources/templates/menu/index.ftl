<!DOCTYPE html>
<html>
<head>
    <title>xxxx</title>
</head>
<body>
    <div id="test">
        {{message}}
    </div>
    <div id="test2">
                    <span v-bind:title="message">
                        鼠标悬停几秒钟查看此处动态绑定的提示信息！
                     </span>
    </div>
    <div id="test3">
                    <span v-if="flag">
                        信息展示
                     </span>
    </div>
    <div id="test4">
        <ol>
            <li v-for="filed in fileds">
                {{filed.text}}
            </li>
        </ol>
    </div>
    <div id="test5">
        <button v-on:click="hiddenTest3">隐藏test3</button>
    </div>
    <div id="test6">
        <input type="text" v-model="userName"/>
    </div>
    <ol id="test7">
        <todo-item v-for="grocery in groceryList" v-bind:todo="grocery" v-bind:key="grocery.id"></todo-item>
    </ol>
    <div id="test8">
        <input type="text" v-bind:id="currentId+'test'"/>
    </div>
</body>

<script src="${request.contextPath}/static/js/vue.js"></script>
<script>
    var app = new Vue({

        el: '#test',
        data: {
            message: 'hello world vue'
        }
    });

    var app2 = new Vue({

        el: '#test2',
        data: {
            message: '页面加载于' + new Date().toLocaleDateString()
        }
    });

    var app3 = new Vue({

        el: '#test3',
        data: {
            flag: true
        }
    });

    var app4 = new Vue({

        el: '#test4',
        data: {
            fileds: [
                {text: 'test1'},
                {text: 'test2'},
                {text: 'test3'}]
        }
    });

    var app5 = new Vue({

        el: '#test5',
        methods: {
            hiddenTest3: function () {

                // 将app3隐藏
                if (app3.flag) {

                    app3.flag = false;
                } else {

                    app3.flag = true;
                }

            }
        }
    });

    var app6 = new Vue({

        el: '#test6',
        data:{
            userName:'test'
        }
    });

    /*Vue.component('todo-item',{
        template:'<li>这是个待办项</li>'
    });*/

    Vue.component('todo-item',{
        props:['todo'],
        template:'<li>{{todo.text}}</li>'
    });

    var app7 = new Vue({
        el:'#test7',
        data:{
            groceryList:[
                {id:0,text:'test1'},
                {id:1,text:'test2'},
                {id:2,text:'test3'},
                {id:3,text:'test4'}
            ]
        }
    });

    var app8 = new Vue({

        el:'#test8',
        data:{
            currentId:'mYId'
        }
    });
</script>
</html>