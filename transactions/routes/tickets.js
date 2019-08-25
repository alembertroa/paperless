var express = require('express');
var ticket = require("../model/tickets");
var router = express.Router();

/* Create new Ticket. */
router.post('/', function(req, res, next) {

    console.log(req.body);

    ticket.create(req.body, function (err, ticket) {
        if (err) return handleError(err);
        res.send({ id :ticket._id});
    });
});

/* Get a Ticket. */
router.get('/:id', function(req, res, next) {

    console.log(req.params.id);

    ticket.findById(req.params.id, function (err, ticket) {
        if(err)
            console.log(err);
        else{
            console.log(ticket);
            res.send(ticket);
        }
    });
});
module.exports = router;
