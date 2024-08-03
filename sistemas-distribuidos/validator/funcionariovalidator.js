const { checkSchema } = require("express-validator");

module.exports = {
    manipulateFuncionario: checkSchema({
        nome: {
            trim: true,
            isLength: {
                options: { min: 2 }
            },
            errorMessage: 'Nome precisa de pelo menos 2 caracteres'
        },
        sobrenome: {
            trim: true,
            isLength: {
                options: { min: 2 }
            },
            errorMessage: 'Sobrenome precisa de pelo menos 2 caracteres'
        },
        cargo: {
            notEmpty: true,
            errorMessage: 'Cargo não foi inserido'
        },
        salario: {
            isFloat: {
                options: { min: 0 }
            },
            errorMessage: 'Salário precisa ser um número positivo'
        },
        cpf: {
            isLength: {
                options: { min: 11, max: 11 }
            },
            errorMessage: 'CPF precisa ter 11 dígitos'
        }
    })
};
