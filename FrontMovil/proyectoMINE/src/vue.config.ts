// vue.config.js
module.exports = {
    configureWebpack: {
      resolve: {
        alias: {
          '@': require('path').resolve(__dirname, 'src')
        }
      }
    },
    chainWebpack: config => {
      config.module
        .rule('vue')
        .use('vue-loader')
        .loader('vue-loader')
        .tap(options => {
          options.compilerOptions = {
            ...options.compilerOptions,
            isCustomElement: tag => tag.startsWith('ion-')
          }
          return options
        })
    }
  };
  