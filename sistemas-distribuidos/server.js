require('dotenv').config({path: 'variable.env'});
const express = require ('express');
const mongoose = require('mongoose');
const cors = require('cors');

const apiRounters = require('./router/routers.js');
const server = express();

// Conexão com o banco de dados
mongoose.connect(process.env.DATABASE, { useNewUrlParser: true, useUnifiedTopology: true });
mongoose.Promise = global.Promise;
mongoose.connection.on('error', (error) => {
    console.error("Erro: " + error.message);
});

server.use(express.json());
server.use(cors());
server.use('/', apiRounters);

server.listen(process.env.PORT, () => {
    console.log(`Servidor rodando na porta: ${process.env.PORT}`);
});