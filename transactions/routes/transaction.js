var express = require('express');
var transaction = require("../model/transaction");
var router = express.Router();

/* Create new Transaction. */
router.post('/', function(req, res, next) {

    console.log(req.body);
    transaction.create(req.body, function (err, transaction) {
        if (err) return handleError(err);
        console.log(transaction._id);
        res.send({ id : transaction._id });
    });
});

module.exports = router;
