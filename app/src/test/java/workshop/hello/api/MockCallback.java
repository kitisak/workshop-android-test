package workshop.hello.api;

import static junit.framework.Assert.fail;

/**
 * Created by somkiat on 10/19/2016 AD.
 */
class MockCallback implements CalculatorApi.CalculatorApiCallback {

    private boolean called = false;

    public boolean verify() {
        return this.called;
    }

    @Override
    public void onSuccess(String result) {
        if(!"5.00".equals(result)) {
            fail();
        }
        called = true;
    }
}
