var express = require('express');
var transaction = require("../model/transaction");
var router = express.Router();

/* GET users listing. */
router.post('/', function(req, res, next) {

    console.log(req.body);
    var payload = {};
    payload.id = 2;
    payload.tickek_id = 100;
    res.send(payload);
});

module.exports = router;
