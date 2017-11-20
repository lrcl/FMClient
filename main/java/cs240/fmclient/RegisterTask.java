package cs240.fmclient;


import android.os.AsyncTask;

class RegisterTask extends AsyncTask<String, String, String> {
    String registerResults;
    @Override
    protected String doInBackground(String... strings) {
        Proxy proxy = new Proxy();
        registerResults = proxy.register(strings);
        System.out.println("line 12");
        if(registerResults != null) {
            System.out.println(registerResults);
           // new FamilyDataTask().execute(registerResults);
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {

    }
}
