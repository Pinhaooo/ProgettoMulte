const mongoose =require('mongoose');

modelu.exports = async () =>{
    try{
        const connectionParams ={
            useNewUrlParser : true ,
            useCreateIndex: true ,
            useUnifiedTopology: true
        };
        await mongoose.connect(
            "mongodb://localhost/todo-app",
            connectionParams
        );
        console.log("connected to dabase")
    }catch(error){
        console.log("could not connecto to database",error)
    }
}