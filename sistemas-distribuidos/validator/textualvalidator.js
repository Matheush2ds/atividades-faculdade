const { checkSchema } = require("express-validator");

module.exports = {
    manipulateTextual: checkSchema({
        name: {
            trim: true,
            isLength: {
                options: { min: 2 }
            },
            errorMessage: 'Nome precisa de pelo menos 2 caracteres'
        },
        title: {
            notEmpty: true,
            errorMessage: 'Título não foi inserido'
        },
        text: {
            isLength: {
                options: { min: 5 }
            },
        },
        fontSize: {
            isInt: true,
            errorMessage: 'Tamanho da fonte não determinado'
        }
    })
};
