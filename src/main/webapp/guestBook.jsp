<!DOCTYPE html>
<%@ page  pageEncoding="utf-8"%>
<html lang="en" >
<head>
    <meta charset="UTF-8">
    <title>Event</title>
    <link rel='stylesheet' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>
</head>
<body>
<!-- partial:index.partial.html -->
<div class="container">
    <h1>留言板</h1>
    <div id="app"></div>
    <div id="button"></div>
</div>
<script>
    var privileges=true;
    alert(privileges==<%=session.getAttribute("privileges")%>)

</script>


<!-- partial -->
<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/react/0.14.3/react.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/react/0.14.3/react-dom.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/react-bootstrap/0.28.1/react-bootstrap.min.js'></script>

<script type="text/javascript" charset="UTF-8">

    var Panel = ReactBootstrap.Panel,Accordion = ReactBootstrap.Accordion;
    var Button = ReactBootstrap.Button,Input = ReactBootstrap.Input;
    var ButtonToolbar = ReactBootstrap.ButtonToolbar;
    var Modal = ReactBootstrap.Modal;
    var OverlayTrigger = ReactBootstrap.OverlayTrigger;
    var ListGroup = ReactBootstrap.ListGroup,ListGroupItem = ReactBootstrap.ListGroupItem;


    var guests = typeof localStorage["guestBook"] != "undefined" ?
        JSON.parse(localStorage["guestBook"]) :
        [
            { title: "林少雄", info: ["18120776162", "murphypp@foxmail.com"] }],

        globalTitle = "",globalInfo = []; // Define global title and info

    // GuestBook class. This holds all guests.
    class GuestBook extends React.Component {
        render() {
            return (
                React.createElement("div", null,
                    React.createElement(Accordion, null,
                        this.props.data)));



        }}


    // Guest class. This is the display for a guest in GuestBook
    class Guest extends React.Component {
        remove() {
            guests.splice(this.props.index, 1);
            update();
        }
        edit() {
            globalTitle = this.props.title;
            globalInfo = this.props.info;
            document.getElementById("show").click();
        }
        render() {
            return (
                React.createElement("div", null,
                    React.createElement("h4", { className: "text-center" }, "留言内容"), React.createElement("hr", null),
                    React.createElement(InfoList, { info: this.props.info }),
                    React.createElement(ButtonToolbar, null,
                        React.createElement(Button, { class: "delete", bsStyle: "danger", id: "btn-del" + this.props.index, onClick: this.remove.bind(this) }, "删除")
                        )));



        }}


    // InfoList class. This lists all info for a Guest
    class InfoList extends React.Component {
        render() {
            var infoList = this.props.info.map(function (dataInfo) {
                return (
                    React.createElement(ListGroupItem, null,
                        dataInfo));


            });
            return (
                React.createElement(ListGroup, null,
                    infoList));


        }}


    //Join button and modal
    class GuestJoins extends React.Component {
        constructor(props) {
            super(props);
            this.state = { showModal: false };
        }
        close() {
            globalTitle = "";
            globalInfo = [];
            this.setState({ showModal: false });
        }
        open() {
            this.setState({ showModal: true });
            if (document.getElementById("title") && document.getElementById("info")) {
                $("#title").val(globalTitle);
                $("#info").val(globalInfo);
                if (globalTitle != "") {
                    $("#modalTitle").text("Edit guest info");
                    $("#addButton").text("Edit guest info");
                }
            } else
                requestAnimationFrame(this.open);
        }
        add() {
            var title = document.getElementById("title").value;
            var info = document.getElementById("info").value.split(",");
            var exists = false;
            for (var i = 0; i < guests.length; i++) {
                if (guests[i].title === title) {
                    guests[i].info = info;
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                if (title.length < 1) title = "Untitled";
                guests.push({ title: title, info: document.getElementById("info").value.split(",") });
            }
            update();
            this.close();
        }
        render() {
            return (
                React.createElement("div", null,
                    React.createElement(Button, {
                        bsStyle: "primary",
                        bsSize: "large",
                        onClick: this.open.bind(this),
                        id: "show" }, "新增留言"),



                    React.createElement(Modal, { show: this.state.showModal, onHide: this.close.bind(this) },
                        React.createElement(Modal.Header, { closeButton: true },
                            React.createElement(Modal.Title, { id: "modalTitle" }, "新增留言")),

                        React.createElement(Modal.Body, null,
                            React.createElement("form", null,
                                React.createElement(Input, { type: "text", label: "姓名", placeholder: "请输入姓名", id: "title" }),
                                React.createElement(Input, { type: "textarea", label: "留言内容", placeholder: "请输入留言内容", id: "info" }))),


                        React.createElement(Modal.Footer, null,
                            React.createElement(Button, { onClick: this.add.bind(this), bsStyle: "primary", id: "addButton" }, "新增"),
                            React.createElement(Button, { onClick: this.close.bind(this) }, "关闭")))));




        }}


    // Update function to display all the guests
    function update() {
        localStorage.setItem("guestBook", JSON.stringify(guests));
        var rows = [];
        for (var i = 0; i < guests.length; i++) {
            rows.push(
                React.createElement(Panel, { header: guests[i].title, eventKey: i, bsStyle: "success" },
                    React.createElement(Guest, { title: guests[i].title, info: guests[i].info, index: i })));


        }
        ReactDOM.render(React.createElement(GuestBook, { data: rows }), document.getElementById("app"));
    };

    ReactDOM.render(React.createElement(GuestJoins, null), document.getElementById("button"));
    update();
</script>

</body>
</html>