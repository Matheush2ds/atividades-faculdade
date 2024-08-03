const express = require('express');
const router = express.Router();

const textualController = require('../controller/textualcontroller');
const TextualValidator = require('../validator/textualvalidator');

const usuarioController = require('../controller/usuariocontroller');
const UsuarioValidator = require('../validator/usuariovalidator');

const funcionarioController = require('../controller/funcionariocontroller');
const FuncionarioValidator = require('../validator/funcionariovalidator');

router.get('/ping', (req, res) => {
    res.json({ retorno: true });
});

// Textual
router.post('/textual/add', TextualValidator.manipulateTextual, textualController.addTextual);
router.delete('/textual/delete/:id', textualController.deleteTextual);
router.get('/textual/get', textualController.getTextual);
router.put('/textual/edit/:id', TextualValidator.manipulateTextual, textualController.editTextual);

// Funcionario
router.post('/funcionario/add', FuncionarioValidator.manipulateFuncionario, funcionarioController.addFuncionario);
router.delete('/funcionario/delete/:id', funcionarioController.deleteFuncionario);
router.get('/funcionario/get', funcionarioController.getAllFuncionarios);
router.put('/funcionario/edit/:id', FuncionarioValidator.manipulateFuncionario, funcionarioController.editFuncionario);

// Usuario
router.post('/usuario/add', UsuarioValidator.manipulateUsuario, usuarioController.addUsuario)
router.delete('/usuario/delete/:id', usuarioController.deleteUsuario);
router.get('/usuario/get', usuarioController.getUsuarios);
router.put('/usuario/edit/:id', UsuarioValidator.manipulateUsuario, usuarioController.editUsuario);

module.exports = router;
