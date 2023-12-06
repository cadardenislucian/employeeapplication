const express = require('express');
const cors = require('cors');
const app = express();

app.use(cors());

// Your other middleware and route handling here

app.listen(8080, () => {
    console.log('Server is running on port 8080');
});

const express = require('express');
const router = express.Router();
const emailController = require('../controllers/emailController');

// Adaugă o nouă rută pentru trimiterea e-mailurilor către angajații selectați
router.post('/email/sendToSelected', emailController.sendEmailToSelected);

module.exports = router;