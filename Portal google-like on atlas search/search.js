const { MongoClient, ObjectID } = require("mongodb");
const Express = require("express");
const Cors = require("cors");
const BodyParser = require("body-parser");
const { request } = require("express");
const uri = "mongodb+srv://mario:mario2022@trinity.7qr2i.mongodb.net/Teologia?retryWrites=true&w=majority";
const client = new MongoClient(uri);



const server = Express();

server.use(BodyParser.json());
server.use(BodyParser.urlencoded({ extended: true }));
server.use(Cors());

var collection;



server.get("/search", async (request, response) => {
    try {
       

        let result = await collection.aggregate([
            {
            $search: {
                index: 'title',
                text: {
                query: `${request.query.query}`,
                path: {
                'wildcard': '*'
                }
              }
            }
        }
        ]).toArray();

        response.send(result);
    } catch (e) {
        response.status(500).send({ message: e.message });
    }
});


server.get("/get/:id", async (request, response) => {
    try {
        let result = await collection.findOne({ "_id": ObjectID(request.params.id) });
        response.send(result);
    } catch (e) {
        response.status(500).send({ message: e.message });
    }
});

server.get("/search", async (request, response) => {});
server.get("/get/:id", async (request, response) => {});

server.listen("3000", async () => {
    try {
        await client.connect();
        collection = client.db("Teologia").collection("topics");
    } catch (e) {
        console.error(e);
    }
});