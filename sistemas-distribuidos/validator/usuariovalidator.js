const { checkSchema } = require("express-validator");

const isTelefone = (value) => {
  const telefoneRegex = /^\(\d{2}\)\s\d{5}-\d{4}$/;
  return telefoneRegex.test(value);
};

const isCep = (value) => {
  const cepRegex = /^\d{5}-\d{3}$/;
  return cepRegex.test(value);
};

module.exports = {
  manipulateUsuario: checkSchema({
    nome: {
      trim: true,
      isLength: {
        options: { min: 2 },
        errorMessage: "Nome precisa de pelo menos 2 caracteres"
      }
    },
    email: {
      isEmail: true,
      errorMessage: "E-mail inválido"
    },
    senha: {
      isLength: {
        options: { min: 6 },
        errorMessage: "Senha precisa ter pelo menos 6 caracteres"
      }
    },
    telefone: {
      custom: {
        options: (value) => isTelefone(value),
        errorMessage: "Telefone inválido, o formato deve ser (99) 99999-9999"
      }
    },
    cep: {
      custom: {
        options: (value) => isCep(value),
        errorMessage: "CEP inválido, o formato deve ser 99999-999"
      }
    }
  })
};
